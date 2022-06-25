package com.MAX.v5.Controller;

import com.MAX.v5.Services.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/vj")
public class Controller {

    private Service service;

    public Controller(Service service) {
        this.service = service;
    }

}
