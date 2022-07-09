package com.MAX.v8.Controller;

import java.util.ArrayList;
import java.util.List;

public class RequestDTO {
    private String name;
    private Integer id;
    private Tool tool;
    private List<Car> carlist = new ArrayList<>();

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

    public List<Car> getCarlist() {
        return carlist;
    }

    public void setCarlist(List<Car> carlist) {
        this.carlist = carlist;
    }
}
