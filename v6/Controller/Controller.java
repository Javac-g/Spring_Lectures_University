package com.MAX.v6.Controller;

import com.MAX.v6.Services.ResponseDTO;
import com.MAX.v6.Services.ServiceMain;
import com.MAX.v6.Services.ServiceOne;
import com.MAX.v6.Services.ServiceTwo;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/vj")
public class Controller {

    private ServiceMain main;
    private ServiceOne testOne;
    private ServiceTwo testTwo;

    public ServiceOne getTestOne() {
        return testOne;
    }

    public void setTestOne(ServiceOne testOne) {
        this.testOne = testOne;
    }

    public Controller(ServiceMain main) {
        this.main = main;
    }
    @GetMapping("/server")
    @ResponseBody
    public String login(){
        return "\n" + testOne.getOne() + "\n" + testOne.getTwo()+ "\n" + testTwo.getOne()+ "\n" + testTwo.getTwo();
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
    @DeleteMapping(value = "/d",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String deleteData(@RequestParam Integer id){
        if (id < 2){
            return main.print("Was deleted person №" + main.deleteA(id));

        } else if (id >= 2) {
            return main.print("Was deleted person №") + main.deleteB(id);
        }

        return "Nobody wasnt deleted";
    }
}
