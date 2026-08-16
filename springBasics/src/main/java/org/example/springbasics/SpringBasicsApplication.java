package org.example.springbasics;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBasicsApplication implements CommandLineRunner {

    private final Student student;

    public SpringBasicsApplication(Student student) {
        this.student=student;
    }
    public static void main(String[] args) {
        SpringApplication.run(SpringBasicsApplication.class, args);
    }
    @Override
    public void run(String... args) {
        student.display();
    }

}
