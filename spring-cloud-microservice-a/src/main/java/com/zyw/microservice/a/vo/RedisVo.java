package com.zyw.microservice.a.vo;

/**
 * @description Redis的VO类
 * @author ZhangYuWei
 * @create 2019-05-08
 */
public class RedisVo {

	private String key; //Redis的key
	private String value; //Redis的value
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return "RedisVo [key=" + key + ", value=" + value + "]";
	}
	
}
