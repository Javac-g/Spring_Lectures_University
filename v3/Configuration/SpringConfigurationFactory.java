package com.MAX.v3.Configuration;

import com.MAX.v3.Controller.Controller;
import com.MAX.v3.Service.Service;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class SpringConfigurationFactory {

    @Bean(name = "Service")
    public Service serviceBean(){

        return new Service();

    }
    @Bean(name = "Controller")
    @Scope(value = "prototype")
    public Controller controllerBean(){

        return new Controller(serviceBean());

    }
}
