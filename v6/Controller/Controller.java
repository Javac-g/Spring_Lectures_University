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
    public ResponseDTO addData(@RequestBody RequestDTO user){

        return main.create(user);

    }
    @GetMapping(value = "/f",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseDTO FindData(@RequestParam Integer id){
        return main.read(id);

    }
    @PutMapping(value = "/u",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseDTO UpdateData(@RequestParam Integer id,@RequestBody RequestDTO user){

        return main.update(id, user);

    }


}
