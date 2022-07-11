package com.MAX.v8.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class ServiceB {
    @Value("${prop.KeyFour}")
    private Long first;
    @Value("${prop.KeyTwo}")
    private String second;

    public Long getFirst() {
        return first;
    }


    public String getSecond() {
        return second;
    }


}


