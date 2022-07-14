package com.MAX.v8.Service;

import org.springframework.beans.factory.annotation.Value;

public class ServiceD {
    @Value("${prop.D}")
    private String one;

    public String getOne() {
        return one;
    }
}
