package com.MAX.v8.Service;

import org.springframework.beans.factory.annotation.Value;

public class ServiceC {

    @Value("${prop.C}")
    private String one;

    public String getOne() {
        return one;
    }
}
