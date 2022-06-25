package com.MAX.v5.Services;

import org.springframework.beans.factory.annotation.Value;



public class ServiceOne {
    @Value("${prop.KeyThree}")
    private  Integer first;
    @Value("${prop.KeyOne}")
    private    String second;

    public  Integer getFirst() {
        return first;
    }

    public  void setFirst(Integer first) {
        this.first = first;
    }

    public   String getSecond() {
        return second;
    }

    public  void setSecond(String second) {
        this.second = second;
    }




}
