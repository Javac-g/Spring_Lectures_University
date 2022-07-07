package com.MAX.v7.Controller;

import com.MAX.v7.Service.ResponseDTO;
import com.MAX.v7.Service.Service;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(value = "/f",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseDTO findData(@RequestParam Integer id){
        return service.read(id);

    }

    @PutMapping(value = "/u",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseDTO updateData(@RequestParam Integer id,@RequestBody RequestDTO json){
        return service.update(id, json);

    }

}//EOF
