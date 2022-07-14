package com.MAX.v8.Controller;

import com.MAX.v8.Service.ServiceOne;
import com.MAX.v8.Service.ServiceTwo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/Third")
public class ControllerRight {
    private static final Logger logger = LoggerFactory.getLogger(ControllerRight.class);
    private ServiceOne serviceOne;

    @Autowired
    private ServiceTwo serviceTwo;

    public ServiceOne getServiceOne() {
        return serviceOne;
    }

    public void setServiceOne(ServiceOne serviceOne) {
        this.serviceOne = serviceOne;
    }

    @GetMapping(value = "/s",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String service(){
        logger.info("service one: " + serviceOne);
        logger.info("service two: " + serviceTwo);
        logger.info("Get mapping --- https:192.168.0.102:8080/vk/s");
        logger.info("Service one - first: {},Service one - second: {},Service two - first: {},Service two - second: {},",serviceOne.getOne(),serviceOne.getTwo(),serviceTwo.getOne(),serviceTwo.getTwo());
        return serviceOne.getOne()+"\n"+serviceOne.getTwo()+"\n"+serviceTwo.getOne()+"\n"+serviceTwo.getTwo();
    }

}
