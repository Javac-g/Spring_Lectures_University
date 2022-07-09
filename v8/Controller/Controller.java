package com.MAX.v8.Controller;

import com.MAX.v8.Service.ResponseDTO;
import com.MAX.v8.Service.Service_Main;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/vk")
public class Controller {

    private Service_Main serviceMain;

    public Controller(Service_Main serviceMain) {
        this.serviceMain = serviceMain;
    }

    @PostMapping(value = "/a",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseDTO addUser(@RequestBody RequestDTO user){
        return serviceMain.Create(user);
    }
}
