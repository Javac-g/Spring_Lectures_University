package com.MAX.v6.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ServiceTwo {

    private String one;
    private Integer two;

    @Autowired
    public ServiceTwo(@Value("${prop.KeyTwo}") String one,@Value("${prop.KeyFour}") Integer two) {
        this.one = one;
        this.two = two;
    }

    public String getOne() {
        return one;
    }

    public void setOne(String one) {
        this.one = one;
    }

    public Integer getTwo() {
        return two;
    }

    public void setTwo(Integer two) {
        this.two = two;
    }
}
