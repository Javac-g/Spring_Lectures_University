package com.MAX.v8.Controller;

import com.MAX.v8.Service.ServiceA;
import com.MAX.v8.Service.ServiceB;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/sc")
public class sideController {
    private ServiceA serviceA;
    private ServiceB serviceB;
    private static final Logger logger = LoggerFactory.getLogger(sideController.class);


    public void setServiceA(ServiceA serviceA) {
        this.serviceA = serviceA;
    }

    public void setServiceB(ServiceB serviceB) {
        this.serviceB = serviceB;
    }

    @GetMapping(value = "/s",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String sab(){
        logger.info("service A: " + serviceA);
        logger.info("service B: " + serviceB);
        logger.info("Get mapping --- https:192.168.0.102:8080/vk/ss");

        return serviceA.getFirst()+"\n"+serviceA.getSecond()+"\n"+serviceB.getFirst()+"\n"+serviceB.getSecond();
    }


}
