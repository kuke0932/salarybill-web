package com.htcs.wework.system.mock_web;

import com.fasterxml.classmate.TypeResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.sql.Timestamp;
import java.time.LocalDate;

import static com.google.common.collect.Lists.newArrayList;

/**
 * @author zhaokaiyuan
 * @create 2018-03-01 13:34
 **/
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Autowired
    private TypeResolver typeResolver;

    @Bean(name = "web")
    public Docket createRestWebApi() {

        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("web")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.htcs.wework"))
                .paths(PathSelectors.regex("/mock/web/.*"))
                .build()
                .apiInfo(apiInfo())
                .pathMapping("/")
                .directModelSubstitute(LocalDate.class, String.class)
                .directModelSubstitute(Timestamp.class, Long.class);
//                .globalResponseMessage(RequestMethod.GET,
//                        newArrayList(new ResponseMessageBuilder()
//                                .code(500)
//                                .message("error")
//                                .responseModel(new ModelRef("ReturnStatus«string»"))
//                                .build()))
//                .globalResponseMessage(RequestMethod.POST,
//                        newArrayList(new ResponseMessageBuilder()
//                                .code(500)
//                                .message("error")
//                                .responseModel(new ModelRef("ReturnStatus«string»"))
//                                .build()))

//                .genericModelSubstitutes(ResponseEntity.class)
                /*.alternateTypeRules(
                        newRule(typeResolver.resolve(DeferredResult.class,
                                typeResolver.resolve(ResponseEntity.class, WildcardType.class)),
                                typeResolver.resolve(WildcardType.class)))*/
    }

    @Bean(name = "admin")
    public Docket createRestAdminApi() {

        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("admin")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.htcs.wework"))
                .paths(PathSelectors.regex("/mock/admin/.*"))
                .build()
                .apiInfo(apiInfo())
                .pathMapping("/")
                .directModelSubstitute(LocalDate.class, String.class)
                .directModelSubstitute(Timestamp.class, Long.class);
//                .globalResponseMessage(RequestMethod.GET,
//                        newArrayList(new ResponseMessageBuilder()
//                                .code(500)
//                                .message("error")
//                                .responseModel(new ModelRef("ReturnStatus«string»"))
//                                .build()))
//                .globalResponseMessage(RequestMethod.POST,
//                        newArrayList(new ResponseMessageBuilder()
//                                .code(500)
//                                .message("error")
//                                .responseModel(new ModelRef("ReturnStatus«string»"))
//                                .build()))

//                .genericModelSubstitutes(ResponseEntity.class)
                /*.alternateTypeRules(
                        newRule(typeResolver.resolve(DeferredResult.class,
                                typeResolver.resolve(ResponseEntity.class, WildcardType.class)),
                                typeResolver.resolve(WildcardType.class)))*/
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("在线api")
                .description("后台管理系统api")
//                .termsOfServiceUrl("http://blog.didispace.com/")
                .version("1.0")
                .build();
    }

    private void globalResponse(Docket docket, int statusCode, String message) {
        docket
                .globalResponseMessage(RequestMethod.GET,
                        newArrayList(new ResponseMessageBuilder()
                                .code(statusCode)
                                .message(message)
                                .responseModel(new ModelRef("ReturnStatus«string»"))
                                .build()))
                .globalResponseMessage(RequestMethod.POST,
                        newArrayList(new ResponseMessageBuilder()
                                .code(statusCode)
                                .message(message)
                                .responseModel(new ModelRef("ReturnStatus«string»"))
                                .build()));

    }
}

