package com.MAX.v4.Configuration;

import com.MAX.v4.Controller.Controller;
import com.MAX.v4.Service.ServiceOne;
import com.MAX.v4.Service.Services;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class SpringConfigurationFactory {

    @Bean(name = "Services")
    public Services servicesBean(){

        return new Services();

    }

//    @Bean
//    public ServiceOne serviceOneBean(){
//
//        return new ServiceOne();
//
//    }

    @Bean(name = "Controller")
    @Scope(value =  "prototype")
    public Controller controllerBean(){
        Controller controller = new Controller();
        controller.setService(servicesBean());
        return controller;
    }

}
