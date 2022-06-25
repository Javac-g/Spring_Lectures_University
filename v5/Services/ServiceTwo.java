package com.MAX.v5.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ServiceTwo {
    private static String three;
    private static Integer four;
    @Autowired
    public ServiceTwo(@Value("${prop.KeyTwo}") String three, @Value("${prop.KeyFour}")Integer four) {
        this.three = three;
        this.four = four;
    }

    public static String getThree() {
        return three;
    }

    public static void setThree(String three) {
        ServiceTwo.three = three;
    }

    public static Integer getFour() {
        return four;
    }

    public static void setFour(Integer four) {
        ServiceTwo.four = four;
    }
}
