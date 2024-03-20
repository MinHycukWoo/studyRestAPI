package kr.co.sample.sampleapi.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    private ApiInfo commonInfo(){
        return new ApiInfoBuilder()
                .title("USER API 메모를 넣는다면 여기")
                .version("1.0 버전표시")
                .build();
    }

    @Bean
    public Docket allApi(){
        return new Docket (DocumentationType.SWAGGER_2)
        //return new Docket(DocumentationType.OAS_30)
                .groupName("USER")
                .useDefaultResponseMessages(false)
                .select()
                .apis(RequestHandlerSelectors.basePackage("kr.co.sample.sampleapi.controller"))
                //.apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(commonInfo());
    }


}
