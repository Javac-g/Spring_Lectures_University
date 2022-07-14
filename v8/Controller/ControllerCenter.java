package com.MAX.v8.Controller;

import com.MAX.v8.Service.ServiceC;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@RequestMapping("/Five")
public class ControllerCenter {
    private static final Logger logger = LoggerFactory.getLogger(ControllerCenter.class);
    private ServiceC serviceC;

    @GetMapping(value = "/s",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String service(){
        logger.info("Service C: {}" , getServiceC());

        logger.info("Get mapping --- https:192.168.0.102:8080/Five/s");

        return getServiceC().getOne();
    }

    protected ServiceC getServiceC(){
        throw new UnsupportedOperationException();
    }
}
