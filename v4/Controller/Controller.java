package com.MAX.v4.Controller;

import com.MAX.v4.Service.ResponseDTO;
import com.MAX.v4.Service.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/vk")
public class Controller {


    private Services service;

    public Services getService() {
        return service;
    }

    public void setService(Services service) {
        this.service = service;
    }

    @GetMapping(value = "/p",produces = MediaType.APPLICATION_JSON_VALUE)
    public String prop(@RequestBody RequestDTO user){

        return "\n" + service.getFirstProperty() + "\n" + service.getSecondProperty();
    }
    @PostMapping(value = "/a",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDTO create(@RequestBody RequestDTO user){
        return service.create(user);
    }

    @GetMapping(value = "/f",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDTO find(@RequestParam Integer id){
        return service.read(id);

    }
    @PutMapping(value = "/u",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDTO update(@RequestParam Integer id,@RequestBody RequestDTO json){
        return service.update(id, json);
    }

    @DeleteMapping(value = "/d",produces = MediaType.APPLICATION_JSON_VALUE)
    public String delete(@RequestParam Integer id){
        if (id > 3){
            return service.print("Second: was deleted person №:" + service.deleteA(id));
        } else if (id <= 3) {
            return service.print("First: was deleted person №:" + service.deleteB(id));
        }

        return "Nobody deleted";

    }
}

