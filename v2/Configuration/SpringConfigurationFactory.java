package com.MAX.v2.Configuration;

import com.MAX.v2.Controller.Controller;
import com.MAX.v2.Service.Service;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class SpringConfigurationFactory {

    @Bean(name = "Service")
    public Service serviceB(){

        return new Service();

    }

    @Bean(name = "Controller")
    @Scope(value = "prototype")
    public Controller controllerB(){

        return new Controller(serviceB());

    }




}
