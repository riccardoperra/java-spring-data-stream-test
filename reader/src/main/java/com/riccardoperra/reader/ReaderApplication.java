package com.riccardoperra.reader;

import com.riccardoperra.reader.repository.TodoReactiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ReaderApplication {
    public static void main(String[] args) {
        SpringApplication.run(ReaderApplication.class, args);
    }

}
