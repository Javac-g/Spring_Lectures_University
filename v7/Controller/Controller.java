package com.MAX.v7.Controller;

import com.MAX.v7.Service.ResponseDTO;
import com.MAX.v7.Service.Service;
import com.MAX.v7.Service.ServiceOne;
import com.MAX.v7.Service.ServiceTwo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/daddy")
public class Controller {
    private Service service;
    private ServiceOne serviceOne;

    @Autowired
    private ServiceTwo serviceTwo;




    public Controller(Service service) {

        this.service = service;
    }

    public ServiceOne getServiceOne() {
        return serviceOne;
    }

    public void setServiceOne(ServiceOne serviceOne) {
        this.serviceOne = serviceOne;
    }

    @PostMapping(value = "/a",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseDTO addData(@RequestBody RequestDTO user){
        return service.create(user);

    }
    @GetMapping(value = "/serv",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String service(){
        return serviceOne.getOne() + "\n " + serviceOne.getTwo() + "\n"+serviceTwo.getOne() + "\n" +serviceTwo.getTwo();

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
    @DeleteMapping(value = "/d",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String deleteData(@RequestParam Integer id){
        if (id % 2 == 0){
            return service.print("Was deleted person N: " + service.deleteA(id));
        } else if (id % 2 != 0) {
            return service.print("Was deleted person N: ") + service.deleteB(id);
        }
        return "Nobody was deleted";
    }

}//EOF
