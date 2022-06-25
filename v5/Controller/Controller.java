package com.MAX.v5.Controller;

import com.MAX.v5.Services.ResponseDTO;
import com.MAX.v5.Services.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/vj")
public class Controller {

    private Service service;

    public Controller(Service service) {
        this.service = service;
    }

    public ResponseDTO create(@RequestBody RequestDTO json){

        return service.create(json);

    }

    public ResponseDTO find(@RequestParam Integer id){

        return service.read(id);

    }
}
