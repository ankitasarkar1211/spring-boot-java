package org.example.springbasics;

import org.springframework.stereotype.Component;

@Component
public class Student {
    public void display() {
        System.out.println("Student bean created");
    }
}
