package com.MAX.v2.Controller;

import com.MAX.v2.Service.CarEnum;

public class ResponseDTO {
    String name;
    Integer id;
    Tool tool;
    CarEnum carEnum ;

    public String getName(){
        return name;
    }
    public void setName(String name){

        this.name = name;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Tool getTool() {
        return tool;
    }

    public void setTool(Tool tool) {
        this.tool = tool;
    }

    public CarEnum getCarEnum() {
        return carEnum;
    }

    public void setCarEnum(CarEnum carEnum) {
        this.carEnum = carEnum;
    }
}
