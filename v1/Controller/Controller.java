package com.MAX.v1.Controller;

import com.MAX.v1.Services.RequestDTO;
import com.MAX.v1.Services.Service;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/sigm")
public class Controller {

    private Service service;

    public Controller(Service service) {
        this.service = service;
    }

    @PostMapping(value = "/a",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseDTO add(@RequestBody RequestDTO user){
        return service.create(user);

    }

    @GetMapping(value = "/f",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseDTO find(@RequestParam Integer id ){

        return service.read(id);

    }

    @PutMapping(value = "/u",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseDTO update(@RequestParam Integer id, @RequestBody RequestDTO json){
        return service.update(id, json);
    }
    @DeleteMapping(value = "/d",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String delete(@RequestParam Integer id){
        if (id < 5){
            return service.print("First - was deleted person № ") + service.delete_one(id);
        }
        else if (id > 5){

            return service.print("Second - was deleted person № ") + service.delete_two(id);
        }
        return "wrong id";
    }
}
