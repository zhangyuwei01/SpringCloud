package com.zyw.microservice.a.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyw.microservice.a.common.RestResponse;
import com.zyw.microservice.a.dao.TableAMapper;
import com.zyw.microservice.a.entity.TableA;
import com.zyw.microservice.a.util.RestUtils;

/**
 * @description 数据库操作的Service
 * @author ZhangYuWei
 * @create 2019-05-12
 */
@Service
public class DataBaseService {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private TableAMapper tableAMapper;
	
	/**
	 * @description 数据库新增数据
	 */
	public RestResponse add(TableA tableA) {
		logger.info("进入add方法，参数是：{}",tableA);
		tableAMapper.addRecord(tableA);
		return RestUtils.returnSuccess("OK");
	}
	
	/**
	 * @description 数据库新增数据
	 */
	public RestResponse delete(Integer aId) {
		logger.info("进入delete方法，参数是：aId={}",aId);
		tableAMapper.deleteRecord(aId);
		return RestUtils.returnSuccess("OK");
	}
	
	/**
	 * @description 数据库新增数据
	 */
	public RestResponse update(TableA tableA) {
		logger.info("进入update方法，参数是：{}",tableA);
		tableAMapper.updateRecord(tableA);
		return RestUtils.returnSuccess("OK");
	}
	
	/**
	 * @description 数据库新增数据
	 */
	public RestResponse find(TableA tableA) {
		logger.info("进入find方法，参数是：{}",tableA);
		List<TableA> tableAList = tableAMapper.findRecord(tableA);
		return RestUtils.returnSuccess(tableAList);
	}
	
	
}
