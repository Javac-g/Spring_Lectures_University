package com.MAX.v6.Controller;

import com.MAX.v6.Services.ResponseDTO;
import com.MAX.v6.Services.ServiceMain;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/vj")
public class Controller {

    private ServiceMain main;

    public Controller(ServiceMain main) {
        this.main = main;
    }


    public ResponseDTO add(@RequestBody RequestDTO user){

        return main.create(user);

    }
}
