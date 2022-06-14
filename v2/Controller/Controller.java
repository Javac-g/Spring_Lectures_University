package com.MAX.v2.Controller;

import com.MAX.v2.Service.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/omega")
public class Controller {

    private Service service;

    public Controller(Service service){

        this.service = service;

    }



}
