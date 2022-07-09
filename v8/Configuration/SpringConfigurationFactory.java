package com.MAX.v8.Configuration;

import com.MAX.v8.Controller.Controller;
import com.MAX.v8.Service.ServiceOne;
import com.MAX.v8.Service.ServiceTwo;
import com.MAX.v8.Service.Service_Main;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class SpringConfigurationFactory {
    @Bean(name = "Main")
    public Service_Main serviceMain(){
        return new Service_Main();
    }
    @Bean("One")
    public ServiceOne serviceOne(){
        return new ServiceOne();
    }
    @Bean(name = "Controller")
    @Scope(value = "prototype")
    public Controller controller(){
        Controller controller = new Controller(serviceMain());
        controller.setServiceOne(serviceOne());
        return controller;
    }

}
