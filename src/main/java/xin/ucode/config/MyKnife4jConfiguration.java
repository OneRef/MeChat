package xin.ucode.config;

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
 * Swagger的配置类
 * http://localhost:8080/doc.html#/home
 */
@Configuration
@EnableSwagger2
public class MyKnife4jConfiguration {
    @Bean(value = "频道")
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("频道模块")
                .select()
                //为当前包路径,控制器类包
                .apis(RequestHandlerSelectors.basePackage("xin.ucode.channel.controller"))
                .paths(PathSelectors.any())
                .build();
    }
    @Bean(value = "系统")
    public Docket createRestApiSys() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("系统模块")
                .select()
                //为当前包路径,控制器类包
                .apis(RequestHandlerSelectors.basePackage("xin.ucode.sys.controller"))
                .paths(PathSelectors.any())
                .build();
    }
    //构建 api文档的详细信息函数,注意这里的注解引用的是哪个
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //页面标题
                .title("MeChat集成knife4 测试接口文档")
                //创建人
                .contact(new Contact("糊福！", "https://space.bilibili.com/35317689", " v2472331253@163.com"))
                //版本号
                .version("1.0")
                //描述
                .description("API 描述")
                .build();
    }
}


