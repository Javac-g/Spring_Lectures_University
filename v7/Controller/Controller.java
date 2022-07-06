package com.MAX.v7.Controller;

import com.MAX.v7.Service.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/daddy")
public class Controller {
    private Service service;

    public Controller(Service service) {
        this.service = service;
    }

}
