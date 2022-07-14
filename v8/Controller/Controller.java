package com.MAX.v8.Controller;

import com.MAX.v8.Service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/vk")
public class Controller {
    private static final Logger logger = LoggerFactory.getLogger(Controller.class);
    private ServiceOne serviceOne;

    private ServiceLP serviceLP;
    private Service_Main serviceMain;
    @Autowired
    private ServiceTwo serviceTwo;



    public ServiceOne getServiceOne() {
        return serviceOne;
    }

    public void setServiceOne(ServiceOne serviceOne) {
        this.serviceOne = serviceOne;
    }

    public Controller(Service_Main serviceMain) {
        this.serviceMain = serviceMain;
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

    @PostMapping(value = "/a",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseDTO addUser(@RequestBody RequestDTO user){
        logger.info("Post mapping --- https:192.168.0.102:8080/vk/a --- body-" + user);
        return serviceMain.Create(user);
    }

    @GetMapping(value = "/f",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseDTO findUser(@RequestParam Integer id){
        logger.info("Get mapping --- https:192.168.0.102:8080/vk/f?id = " + id);
        return serviceMain.Read(id);
    }

    @PutMapping(value = "/u",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseDTO updateUser(@RequestParam Integer id,
                                  @RequestBody RequestDTO user){
        logger.info("Put mapping --- https:192.168.0.102:8080/vk/u?id=" + id);
        logger.info("body - " + user);
        return serviceMain.update(id,user);
    }

    @DeleteMapping(value = "/d",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String deleteUser(@RequestParam Integer id){
        if (id < 2){
            logger.info("Post mapping - Method A - https:192.168.0.102:8080/vk/d?id =" + id);
            return serviceMain.print("Was deleted person N: " + serviceMain.deleteA(id));
        } else if (id >= 2) {
            logger.info("Post mapping - Method B - https:192.168.0.102:8080/vk/d?id =" + id);
            return serviceMain.print("Was deleted person N: ") + serviceMain.deleteB(id);
        }
        return "Nope";
    }
}
