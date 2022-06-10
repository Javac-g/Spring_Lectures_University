package com.MAX.Controller;

import com.MAX.Services.RequestDTO;
import com.MAX.Services.Service;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/sigma")
public class Controller {

    private Service service;

    public Controller(Service service) {
        this.service = service;
    }

    @PostMapping(value = "/a",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseDTO add(@RequestBody RequestDTO user){
        return service.create(user);

    }

    public

}
