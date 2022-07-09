package com.MAX.v8.Controller;

import com.MAX.v8.Service.ResponseDTO;
import com.MAX.v8.Service.Service_Main;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/vk")
public class Controller {

    private Service_Main serviceMain;

    public Controller(Service_Main serviceMain) {
        this.serviceMain = serviceMain;
    }

    @PostMapping(value = "/a",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseDTO addUser(@RequestBody RequestDTO user){
        return serviceMain.Create(user);
    }

    @GetMapping(value = "/f",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseDTO findUser(@RequestParam Integer id){
        return serviceMain.Read(id);
    }

    @PutMapping(value = "/u",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseDTO updateUser(@RequestParam Integer id,
                                  @RequestBody RequestDTO user){

        return serviceMain.update(id,user);
    }

    @DeleteMapping(value = "/d",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String deleteUser(@RequestParam Integer id){
        if (id < 2){
            return serviceMain.print("Was deleted person N: " + serviceMain.deleteA(id));
        } else if (id >= 2) {
            return serviceMain.print("Was deleted person N: ") + serviceMain.deleteB(id);
        }
        return "Nope";
    }
}
