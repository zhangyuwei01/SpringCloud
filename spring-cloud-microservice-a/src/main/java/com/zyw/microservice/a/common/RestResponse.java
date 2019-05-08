package com.zyw.microservice.a.common;

import com.zyw.microservice.a.constant.RestConstants;

/**
 * @description 公用Rest响应结果封装类
 * @author ZhangYuWei
 * @create 2019-05-08
 */
public class RestResponse {
	
	private String status = RestConstants.SUCCESS; //执行结果状态
	private String message = ""; //成功或者失败的提示信息
	private Object data = ""; //返回结果对象
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		return "RestResponse [status=" + status + ", message=" + message + ", data=" + data + "]";
	}
	
}
