package com.zyw.microservice.b;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @description Swagger2配置类
 * @author ZhangYuWei
 * @create 2019-05-08
 */
@Configuration
@EnableSwagger2
public class Swagger2 {

	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.zyw.microservice.b.controller"))
				.paths(PathSelectors.any())
				.build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("微服务B")
				.description("微服务B")
				.termsOfServiceUrl("http://localhost:8002").contact(new Contact("ZhangYuWei",
						"http://localhost:8002/spring-cloud/swagger-ui.html", "zhangyuwei01@foxmail.com"))
				.version("1.0")
				.build();
	}

}
