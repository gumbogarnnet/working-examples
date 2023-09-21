package com.DOCKER.dockerspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@Controller
public class DockerSpringBootApplication {

    @GetMapping("/")
    @ResponseBody
    public String load() {
        return "Success";
    }

    public static void main(String[] args) {
        SpringApplication.run(DockerSpringBootApplication.class, args);
    }

}
