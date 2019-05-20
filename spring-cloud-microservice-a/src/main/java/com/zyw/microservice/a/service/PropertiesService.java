package com.zyw.microservice.a.service;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import com.zyw.microservice.a.common.RestResponse;
import com.zyw.microservice.a.util.RestUtils;

/**
 * @description 读取属性文件的Service
 * @author ZhangYuWei
 * @create 2019-05-20
 */
@Service
@PropertySource(value = { "classpath:config/config1.properties", "classpath:config/config2.properties",
		"file:${spring.properties.path}/config3.properties" }, ignoreResourceNotFound = true)
public class PropertiesService {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	// 从配置文件中获取属性值
	@Value("${property.one}")
	private String propertyOne;
	@Value("${property.two}")
	private String propertyTwo;

	/**
	 * @description 获取属性文件中的属性值
	 */
	public RestResponse get() {
		logger.info("进入get方法，无参数......");
		Map<String, Object> propertiesMap = new HashMap<>();
		propertiesMap.put("propertyOne", propertyOne);
		propertiesMap.put("propertyTwo", propertyTwo);
		return RestUtils.returnSuccess(propertiesMap);
	}

}
