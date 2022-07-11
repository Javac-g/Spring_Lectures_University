package com.MAX.v8.Service;

import org.springframework.beans.factory.annotation.Value;

public class ServiceA {

    @Value("${prop.KeyThree}")
    private Long first;

    @Value("${prop.KeyOne}")
    private String second;

    public Long getFirst() {
        return first;
    }

    public String getSecond() {
        return second;
    }

}
