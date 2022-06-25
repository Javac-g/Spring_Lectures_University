package com.MAX.v5.Controller;

import com.MAX.v5.Services.ResponseDTO;
import com.MAX.v5.Services.Service;
import com.MAX.v5.Services.ServiceOne;
import com.MAX.v5.Services.ServiceTwo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/vj")
public class Controller {
    @Autowired
    private ServiceOne serviceOne;
    private ServiceTwo serviceTwo;
    private Service service;

    public ServiceOne getServiceOne() {
        return serviceOne;
    }

    public void setServiceOne(ServiceOne serviceOne) {
        this.serviceOne = serviceOne;
    }

    public Controller(Service service,ServiceOne serviceOne) {
        this.serviceOne = serviceOne;
        this.service = service;
    }
    @GetMapping(value = "/service",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String one(){
        return "S1: " + serviceOne.getFirst() + " / " + serviceOne.getSecond() + "\nS2: " + serviceTwo.getThree() + " / " + serviceTwo.getFour();
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
        return service.update(id,json);
    }
    @DeleteMapping(value = "/d",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String delete(@RequestParam Integer id){
        if (id <= 3){
            return service.print("Was deleted person №" + service.deleteA(id));
        } else if (id > 3) {
            return service.print("Was deleted person №") + service.deleteB(id);
        }

        return "Nobody wasn't deleted";
    }
}
