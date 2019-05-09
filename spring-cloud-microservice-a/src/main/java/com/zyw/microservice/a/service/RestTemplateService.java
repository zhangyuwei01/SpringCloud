package com.zyw.microservice.a.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.zyw.microservice.a.common.RestResponse;
import com.zyw.microservice.a.util.RestUtils;

/**
 * @description RestTemplate --> 供微服务B调用的Service
 * @author ZhangYuWei
 * @update 2019-05-09
 */
@Service
public class RestTemplateService {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
    private DiscoveryClient discoveryClient;
	
	/**
	 * @description 生产者 - get请求：被微服务B调用
	 */
	public RestResponse producerGet(String token, String param1, String param2) {
		logger.info("进入producerGet方法，参数是：token={},param1={},param2={}",token,param1,param2);
		Map<String,Object> returnMap = new HashMap<>();//返回前端的Map结果集
		StringBuilder servicesInfo = new StringBuilder();//发现当前的服务，并提供服务的信息
		List<String> serviceIds = discoveryClient.getServices();
		if(!CollectionUtils.isEmpty(serviceIds)){
			for(String serviceId : serviceIds){
				logger.info("serviceId:" + serviceId);
				List<ServiceInstance> serviceInstances =  discoveryClient.getInstances(serviceId);
				if(!CollectionUtils.isEmpty(serviceInstances)){
					for(ServiceInstance serviceInstance : serviceInstances){
						servicesInfo.append("[");
						servicesInfo.append(serviceInstance.getServiceId());
						servicesInfo.append(" host=" +serviceInstance.getHost());
						servicesInfo.append(" port=" + serviceInstance.getPort());
						servicesInfo.append(" uri=" + serviceInstance.getUri());
						servicesInfo.append("]");
					}
				}else{
					servicesInfo.append("no service...");
			    }
			}
		}
		returnMap.put("token", token);
		returnMap.put("param1", param1);
		returnMap.put("param2", param2);
		returnMap.put("servicesInfo", servicesInfo.toString());
		return RestUtils.returnSuccess(returnMap);
	}
	
	/**
	 * @description 生产者 - post请求：被微服务B调用
	 */
	public RestResponse producerPost(String token, Map<String,Object> params) {
		logger.info("进入producerPost方法，参数是：token={},params={}",token,params);
		Map<String,Object> returnMap = new HashMap<>();//返回前端的Map结果集
		StringBuilder servicesInfo = new StringBuilder();//发现当前的服务，并提供服务的信息
		List<String> serviceIds = discoveryClient.getServices();
		if(!CollectionUtils.isEmpty(serviceIds)){
			for(String serviceId : serviceIds){
				logger.info("serviceId:" + serviceId);
				List<ServiceInstance> serviceInstances =  discoveryClient.getInstances(serviceId);
				if(!CollectionUtils.isEmpty(serviceInstances)){
					for(ServiceInstance serviceInstance : serviceInstances){
						servicesInfo.append("[");
						servicesInfo.append(serviceInstance.getServiceId());
						servicesInfo.append(" host=" +serviceInstance.getHost());
						servicesInfo.append(" port=" + serviceInstance.getPort());
						servicesInfo.append(" uri=" + serviceInstance.getUri());
						servicesInfo.append("]");
					}
				}else{
					servicesInfo.append("no service...");
			    }
			}
		}
		returnMap.put("token", token);
		returnMap.put("param1", params.get("param1"));
		returnMap.put("param2", params.get("param2"));
		returnMap.put("servicesInfo", servicesInfo.toString());
		return RestUtils.returnSuccess(returnMap);
	}
	
}
