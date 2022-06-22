package com.MAX.v4.Controller;

import com.MAX.v4.Service.ResponseDTO;
import com.MAX.v4.Service.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vk")
public class Controller {

    @Autowired
    private Services service;

    @PostMapping(value = "/a",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDTO create(@RequestBody RequestDTO user){
        return service.create(user);
    }
}
