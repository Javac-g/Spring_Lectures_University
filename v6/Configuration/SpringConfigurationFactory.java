package com.MAX.v6.Configuration;

import com.MAX.v6.Controller.Controller;
import com.MAX.v6.Services.ServiceMain;
import com.MAX.v6.Services.ServiceOne;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class SpringConfigurationFactory {


    @Bean(name = "ServiceMain")
    public ServiceMain serviceMainBean(){
        return new ServiceMain();

    }


    @Bean(name = "ServiceOne")
    public ServiceOne serviceOneBean(){
        return new ServiceOne();

    }
    @Bean(name = "Controller")
    @Scope(value = "prototype")
    public Controller controller(){
        Controller controller = new Controller(serviceMainBean());
        controller.setTestOne(serviceOneBean());
        return controller;
    }
}
