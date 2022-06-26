package com.MAX.v6.Controller;

import com.MAX.v6.Services.ServiceMain;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/vj")
public class Controller {

    private ServiceMain main;

    public Controller(ServiceMain main) {
        this.main = main;
    }

}
