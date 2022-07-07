package com.MAX.v7.Controller;

import com.MAX.v7.Service.ResponseDTO;
import com.MAX.v7.Service.Service;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/daddy")
public class Controller {
    private Service service;


    public Controller(Service service) {

        this.service = service;
    }
    @PostMapping(value = "/a",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseDTO addData(@RequestParam RequestDTO user){
        return service.create(user);

    }

}
