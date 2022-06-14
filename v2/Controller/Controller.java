package com.MAX.v2.Controller;

import com.MAX.v2.Service.RequestDTO;
import com.MAX.v2.Service.Service;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/omega")
public class Controller {

    private Service service;

    public Controller(Service service){

        this.service = service;

    }

    @PostMapping(value = "/a",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseDTO add(@RequestBody RequestDTO json){

        return service.create(json);

    }
    @GetMapping(value = "/f",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseDTO find(@RequestParam Integer id){

        return service.read(id);
    }
    @PutMapping(value = "/u",produces = MediaType.APPLICATION_JSON_VALUE) //@RequestMapping(value = "/u",method = RequestMethod.PUT)
    @ResponseBody
    public ResponseDTO update(@RequestParam Integer id,@RequestBody RequestDTO json){

        return service.update(id,json);

    }



}
