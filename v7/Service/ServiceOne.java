package com.MAX.v7.Service;

import org.springframework.beans.factory.annotation.Value;

public class ServiceOne {
    @Value("${prop.KeyOne}")
    private String One;
    @Value("${prop.KeyFour}")
    private Integer two;

    public String getOne() {
        return One;
    }

    public void setOne(String one) {
        One = one;
    }

    public Integer getTwo() {
        return two;
    }

    public void setTwo(Integer two) {
        this.two = two;
    }
}
