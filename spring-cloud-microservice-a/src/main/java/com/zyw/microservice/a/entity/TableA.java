package com.zyw.microservice.a.entity;

/**
 * @description A表的实体类
 * @author ZhangYuWei
 * @create 2019-05-12
 */
public class TableA {
	
	private Integer aId; //A表主键
	
	private String aField1; //字段一
	
	private String aField2; //字段二

	public Integer getaId() {
		return aId;
	}

	public void setaId(Integer aId) {
		this.aId = aId;
	}

	public String getaField1() {
		return aField1;
	}

	public void setaField1(String aField1) {
		this.aField1 = aField1;
	}

	public String getaField2() {
		return aField2;
	}

	public void setaField2(String aField2) {
		this.aField2 = aField2;
	}

	@Override
	public String toString() {
		return "TableA [aId=" + aId + ", aField1=" + aField1 + ", aField2=" + aField2 + "]";
	}

}
