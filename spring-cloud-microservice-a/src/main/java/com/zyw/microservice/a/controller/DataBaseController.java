package com.zyw.microservice.a.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zyw.microservice.a.common.RestResponse;
import com.zyw.microservice.a.entity.TableA;
import com.zyw.microservice.a.service.DataBaseService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @description 数据库操作的Controler
 * @author ZhangYuWei
 * @create 2019-05-12
 */
@RestController
@RequestMapping(value="/a/database")
@Api(value = "DataBase")
public class DataBaseController {
	@Autowired
	private DataBaseService dataBaseService;
	
	@PostMapping(value="/add")
	@ApiOperation(value = "数据库新增", notes = "参数是：A表的字段")
	public RestResponse add(@RequestBody TableA tableA) {
		return dataBaseService.add(tableA);
	}
	
	@GetMapping(value="/delete")
	@ApiOperation(value = "数据库删除", notes = "参数是：A表的主键")
	public RestResponse delete(@RequestParam Integer aId) {
		return dataBaseService.delete(aId);
	}
	
	@PostMapping(value="/update")
	@ApiOperation(value = "数据库修改", notes = "参数是：A表的字段")
	public RestResponse update(@RequestBody TableA tableA) {
		return dataBaseService.update(tableA);
	}
	
	@PostMapping(value="/find")
	@ApiOperation(value = "数据库查询", notes = "参数是：A表的字段")
	public RestResponse find(@RequestBody TableA tableA) {
		return dataBaseService.find(tableA);
	}
	
}
