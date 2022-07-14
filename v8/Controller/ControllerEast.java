package com.MAX.v8.Controller;

import com.MAX.v8.Service.ServiceD;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/Six")
public class ControllerEast {
    private static final Logger logger = LoggerFactory.getLogger(ControllerEast.class);
    private ServiceD serviceD;

    public ServiceD getServiceD() {
        return serviceD;
    }

    public void setServiceD(ServiceD serviceD) {
        this.serviceD = serviceD;
    }

    @GetMapping(value = "/s",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String service(){
        logger.info("Service D: {}" , serviceD);

        logger.info("Get mapping --- https:192.168.0.102:8080/Six/s");

        return serviceD.getOne();
    }
}
