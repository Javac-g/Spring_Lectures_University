package com.MAX.v3.Controller;

import com.MAX.v3.Service.ResponseDTO;
import com.MAX.v3.Service.Service;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/App")
public class Controller {

    private Service service;

    public Controller(Service service) {
        this.service = service;
    }

    @PostMapping(value = "/a",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseDTO create(@RequestBody RequestDTO json){

        return service.create(json);

    }
    @GetMapping(value = "/f",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseDTO find(@RequestParam Integer id){

        return service.read(id);

    }
    @PutMapping(value = "/u",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseDTO update(@RequestParam Integer id,@RequestBody RequestDTO json){

        return service.update(id, json);

    }
    @DeleteMapping(value = "/d",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String delete(@RequestParam Integer id){
        return service.delete(service.print("Was deleted person №"),id );
    }
}
