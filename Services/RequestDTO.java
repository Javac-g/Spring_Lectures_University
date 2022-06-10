package com.MAX.Services;

import com.MAX.Controller.Car;
import com.MAX.Controller.Tool;

import java.util.ArrayList;
import java.util.List;

public class RequestDTO {
    String name;
    Integer id;
    Tool tool;
    List<Car> carList = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
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

    public List<Car> getCarList() {
        return carList;
    }

    public void setCarList(List<Car> carList) {
        this.carList = carList;
    }
}
