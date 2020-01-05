package com.ys.swagger_demo.config;

import com.ys.swagger_demo.annotation.Flag;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @Description 配置swagger
 * @auther wcc
 * @create 2019-12-25 22:29
 */
@Configuration
public class SwaggerConfig {

    private Docket createDocket(Environment environment, String groupName){
        /**
         * 1、maven 配置的swagger是2.5的，所以DocumentationType = DocumentationType.SWAGGER_2
         * 2、RequestHandlerSelectors：配置要扫描接口的方式
         *      basePackage：指定要扫描的包
         *      any：全部扫描
         *      non：全部不扫描
         *      withMethodAnnotation：扫描方法上的注解
         *      withClassAnnotation：扫描类上的注解
         * 3、PathSelectors：过滤路径(只要符合规则的接口)
         *      ant：使用ant风格过滤
         *      regex：正则过滤
         *      none：全不显示
         *      any：全部显示
         * 4、配置API文档分组：配置多个Docket
         *
         *      .groupName("yuanjian")
         */
        //在开发使用swagger，生产不启用swagger
        // 通过获取系统的配置环境， 如果是生产环境关闭swagger

        boolean flag = environment.acceptsProfiles(Profiles.of("pro"));

        return new Docket(DocumentationType.SWAGGER_2).
                apiInfo(createApiInfo())
                .enable(!flag) //是否启动swagger
                .groupName(groupName)
                .select()
                //.apis(RequestHandlerSelectors.basePackage("com.ys.swagger_demo.controller"))
                .apis(RequestHandlerSelectors.withMethodAnnotation(Flag.class))
                .paths(PathSelectors.any())
                .build();
    }

    @Bean
    public Docket yuanjian(Environment environment) {
        return createDocket(environment, "yuanjian");
    }

    @Bean
    public ApiInfo createApiInfo() {

        /**
         * 作者
         */
        Contact contact = new Contact("yuanjian",
                "http://www.blog.tomcy.com",
                "yuanjian@yscredit.com");

        /**
         * 接口文档基本信息
         */
        return new ApiInfoBuilder()
                .title("YuanJian Api文档")
                .description("再小的帆，也能远航。")
                .termsOfServiceUrl("")
                .version("1.0")
                .build();


    }

}
