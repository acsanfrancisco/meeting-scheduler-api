package com.acsanfrancisco.meeting_scheduler_api.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringOpenApiConfig {

    @Bean
  public OpenAPI openAPI(){
      return new OpenAPI()
              .info(new Info()
                      .title("Rest API - Meetings/Messages Scheduler ")
                      .description("Rest API designed to schedule meetings or messages, supporting CRUD operations")
                      .version("v1"));
  }
}
