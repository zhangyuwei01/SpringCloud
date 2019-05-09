package com.zyw.microservice.b.util;

import com.zyw.microservice.b.common.RestResponse;
import com.zyw.microservice.b.constant.RestConstants;

/**
 * @description Rest处理工具类
 * @author ZhangYuWei
 * @create 2019-05-08
 */
public class RestUtils {

	public static RestResponse returnSuccess(String message) {
		RestResponse restResponse = new RestResponse();
		restResponse.setStatus(RestConstants.SUCCESS);
		restResponse.setMessage(message);
		return restResponse;
	}
	
	public static RestResponse returnSuccessWithString(String data) {
		RestResponse restResponse = new RestResponse();
		restResponse.setStatus(RestConstants.SUCCESS);
		restResponse.setData(data);
		return restResponse;
	}

	public static RestResponse returnSuccess(Object data) {
		RestResponse restResponse = new RestResponse();
		restResponse.setStatus(RestConstants.SUCCESS);
		restResponse.setData(data);
		return restResponse;
	}

	public static RestResponse returnSuccess(String message, Object data) {
		RestResponse restResponse = new RestResponse();
		restResponse.setStatus(RestConstants.SUCCESS);
		restResponse.setMessage(message);
		restResponse.setData(data);
		return restResponse;
	}
	
	public static RestResponse returnFailure(String message) {
		RestResponse restResponse = new RestResponse();
		restResponse.setStatus(RestConstants.FAIL);
		restResponse.setMessage(message);
		return restResponse;
	}

}
