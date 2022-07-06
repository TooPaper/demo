package com.example.config;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.ApplicationListener;
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

import java.net.Inet4Address;
import java.net.UnknownHostException;

/**
 * @Description 接口文档配置
 * @Author snq
 * @Date 2022/6/5 14:31
 */
@Configuration
@EnableSwagger2
@Slf4j
public class SwaggerConfig implements ApplicationListener<WebServerInitializedEvent> {

    Logger logger = LoggerFactory.getLogger(SwaggerConfig.class);

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.analysis.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("数据解析 RESTful APIs")
                .description("RESTful APIs")
                .termsOfServiceUrl("http://localhost:8998/")
                .contact(new Contact("xxxx", "www.xxxx.xxxx", "xxxxx@qq.com"))
                .version("1.0")
                .build();
    }

    @Override
    public void onApplicationEvent(WebServerInitializedEvent event) {
        try {
            //获取IP
            String hostAddress = Inet4Address.getLocalHost().getHostAddress();
            //获取端口号
            int port = event.getWebServer().getPort();
            //获取应用名
            String applicationName = event.getApplicationContext().getApplicationName();
            logger.info("项目启动启动成功！接口文档地址: http://" + hostAddress + ":" + event.getWebServer().getPort() + applicationName + "/swagger-ui.html#");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
