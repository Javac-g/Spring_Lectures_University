package com.MAX.v6.Services;

import org.springframework.beans.factory.annotation.Value;

public class ServiceOne {
    @Value("${prop.KeyOne}")
    private String one;
    @Value("${prop.KeyThree}")
    private Integer two;

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
