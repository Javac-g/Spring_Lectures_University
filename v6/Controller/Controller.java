package com.MAX.v6.Controller;

import com.MAX.v6.Services.ResponseDTO;
import com.MAX.v6.Services.ServiceMain;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/vj")
public class Controller {

    private ServiceMain main;

    public Controller(ServiceMain main) {
        this.main = main;
    }
    @PostMapping(value = "/a",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseDTO add(@RequestBody RequestDTO user){

        return main.create(user);

    }
    @GetMapping(value = "/f",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseDTO Find(@RequestParam Integer id){
        return main.read(id);

    }


}
