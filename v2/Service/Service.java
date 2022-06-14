package com.MAX.v2.Service;

import com.MAX.v2.Controller.ResponseDTO;

import java.util.ArrayList;
import java.util.List;

public class Service {
    List<ResponseDTO> datalist = new ArrayList<>();

    public String print(Integer id){

        return"Person № - [" + id + "] was deleted ";

    }
}
