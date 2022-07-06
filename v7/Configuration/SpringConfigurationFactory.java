package com.MAX.v7.Configuration;

import com.MAX.v7.Controller.Controller;
import com.MAX.v7.Service.Service;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class SpringConfigurationFactory {
    @Bean(name = "MainService")
    public Service serviceBean(){
        return new Service();
    }

    @Bean(name = "Controller")
    @Scope(value = "prototype")
    public Controller controllerBean(){

        Controller controller = new Controller(serviceBean());
        return controller;
    }
}
