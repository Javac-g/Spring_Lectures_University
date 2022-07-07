package com.MAX.v7.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ServiceTwo {
    private String One;
    private Integer Two;

    @Autowired
    public ServiceTwo(@Value("${prop.KeyTwo}") String one, @Value("${prop.KeyThree}") Integer two) {
        One = one;
        Two = two;
    }

    public String getOne() {
        return One;
    }

    public void setOne(String one) {
        One = one;
    }

    public Integer getTwo() {
        return Two;
    }

    public void setTwo(Integer two) {
        Two = two;
    }
}
