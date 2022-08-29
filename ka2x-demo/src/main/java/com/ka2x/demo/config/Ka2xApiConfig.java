package com.ka2x.demo.config;

import com.ka2x.swagger.config.Ka2xApiRegister;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Ka2xApiConfig {

    @Bean
    public Ka2xApiRegister ka2xApiRegister() {
        return new Ka2xApiRegister();
    }


}
