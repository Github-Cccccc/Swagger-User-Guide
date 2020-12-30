package com.staticzz.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {


    @Bean
    public Docket docket2() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("B")
                .enable(false)
                ;
    }

    @Bean
    public Docket docket1(Environment environment) {
        // 设置要显示swagger的环境
        Profiles of = Profiles.of("dev", "test");
        // 判断当前是否处于该环境
        // 通过 enable() 接收此参数判断是否要显示
        boolean b = environment.acceptsProfiles(of);

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("A")
                .enable(b)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.staticzz.controller"))
                .build()
                ;
    }

    /**
     * 配置api文档信息
     * @return
     */
    Contact contact = new Contact("chencc", "", "socrates11@foxmail.com");
    private ApiInfo apiInfo() {
        return new ApiInfo(
                "chencc的api接口文档",
                "后端接口文档",
                "1.0",
                "urn:tos",
                contact,
                "blog",
                "http://www.csnd");
    }

}
