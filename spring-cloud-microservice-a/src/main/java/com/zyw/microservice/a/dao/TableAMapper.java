package com.zyw.microservice.a.dao;

import java.util.List;

import com.zyw.microservice.a.entity.TableA;

/**
 * @description A表的Mapper
 * @author ZhangYuWei
 * @create 2019-05-12
 */
public interface TableAMapper {
	
	//新增一条记录
	public void addRecord(TableA tableA);
	
	//删除一条记录
	public void deleteRecord(Integer aId);
	
	//修改一条记录
	public void updateRecord(TableA tableA);
	
	//条件查询多条记录
	public List<TableA> findRecord(TableA tableA);
	
}
