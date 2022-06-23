package com.MAX.v4.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Component
public class ServiceOne {
    private static String firstProperty;

    private static String secondProperty;




    @Autowired
    public ServiceOne(@Value("${prop.KeyOne}") String firstProperty, @Value("${prop.KeyTwo}") String secondProperty) {
        this.firstProperty = firstProperty;
        this.secondProperty = secondProperty;
    }

    public String getFirstProperty() {
        return firstProperty;
    }

    public void setFirstProperty(String firstProperty) {
        this.firstProperty = firstProperty;
    }

    public String getSecondProperty() {
        return secondProperty;
    }

    public void setSecondProperty(String secondProperty) {
        this.secondProperty = secondProperty;
    }
}
