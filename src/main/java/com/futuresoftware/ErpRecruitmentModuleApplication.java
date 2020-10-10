package com.futuresoftware;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class ErpRecruitmentModuleApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(ErpRecruitmentModuleApplication.class, args);
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {

		return new BCryptPasswordEncoder();
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ErpRecruitmentModuleApplication.class);
	}

	@Bean
	public Docket swaggerConfig() {

		return new Docket(DocumentationType.SWAGGER_2).select().paths(PathSelectors.any())
				.apis(RequestHandlerSelectors.basePackage("com.futuresoftware")).build().apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {

		Contact contact = new Contact("Ahmad", "www.ahmad.com", "ahmad@gmail.com");
		return new ApiInfo("Recruitment API", "users are welcome to login after registering their data to our database",
				"1.0", "terms of use are free", contact, "API License: free", "www.licenseurl.com",
				Collections.emptyList());
	}

}
