package com.MAX.v8.Configuration;

import com.MAX.v8.Controller.*;
import com.MAX.v8.Service.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

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

    @Bean("A")
    @Scope(value = "prototype")
    public ServiceA serviceA(){
        return new ServiceA();
    }


    @Bean("B")
    @Scope(value = "prototype")
    public ServiceB serviceB(){
        return new ServiceB();
    }
    @Bean("C")
    @Scope(value = "prototype")
    public ServiceC serviceC(){
        return new ServiceC();
    }
    @Bean("D")
    @Scope(value = "prototype" ,proxyMode = ScopedProxyMode.TARGET_CLASS)
    public ServiceD serviceD(){

        return new ServiceD();
    }


    @Bean(name = "Controller")
    @Scope(value = "prototype")
    public Controller controller(){
        Controller controller = new Controller(serviceMain());

        return controller;
    }
    @Bean(name = "sideController")
    @Scope(value = "request")
    public sideController sideController(){
        sideController sideController = new sideController();
        sideController.setServiceA(serviceA());
        sideController.setServiceB(serviceB());
        return sideController;
    }
    @Bean(name = "ControllerRight")
    @Scope(value = "prototype")
    public ControllerRight controllerRight(){
        ControllerRight controllerRight = new ControllerRight();
        controllerRight.setServiceOne(serviceOne());
        return controllerRight;
    }
    @Bean(name = "ControllerCenter")
    public ControllerCenter controllerCenter(){
        ControllerCenter controllerC = new ControllerCenter(){
            @Override
            protected ServiceC getServiceC(){
                return serviceC();
            }
        };
        return controllerC;
    }
    @Bean("ControllerEast")
    public ControllerEast controllerEast(){
        ControllerEast controllerEast = new ControllerEast();
        controllerEast.setServiceD(serviceD());
        return controllerEast;
    }
}
