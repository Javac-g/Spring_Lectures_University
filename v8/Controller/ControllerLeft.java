package com.MAX.v8.Controller;

import com.MAX.v8.Service.ServiceLP;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("second")
@Controller
public class ControllerLeft {

    private static final Logger logger = LoggerFactory.getLogger(ControllerLeft.class);
    @Lookup
    public ServiceLP getServiceLP(){
        return null;
    }
    @GetMapping(value = "/lp",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String up(){

        logger.info("Get mapping --- https:192.168.0.102:8080/vk/lp");
        logger.info("Service Look: {}" , getServiceLP());
        return getServiceLP().getOne() + "\n" + getServiceLP().getTwo();
    }

}
