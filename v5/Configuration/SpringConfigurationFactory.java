package com.MAX.v5.Configuration;

import com.MAX.v5.Controller.Controller;
import com.MAX.v5.Services.Service;
import com.MAX.v5.Services.ServiceOne;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class SpringConfigurationFactory {

    @Bean(name = "Service")
    public Service serviceBean(){
        return new Service();
    }
    @Bean
    public ServiceOne serviceOneBean(){

        return new ServiceOne();


    }

    @Bean(name = "Controller")
    @Scope(value =  "prototype")
    public Controller controllerBean(){

        return new Controller(serviceBean(),serviceOneBean());
//       controller.setServiceOne(serviceOneBean());
//       return controller;
    }

}
