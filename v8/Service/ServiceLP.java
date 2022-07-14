package com.MAX.v8.Service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ServiceLP {
    @Value("${prop.L1}")
    private String one;

    @Value("${prop.L2}")
    private Integer two;

    public String getOne() {
        return one;
    }


    public Integer getTwo() {
        return two;
    }

}
