package com.likelion14.springhw;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NameController {
    @GetMapping("/my-name")
    public String getMyName() {
        return "이희수";
    }

    @GetMapping("/hello-json")
    public HelloResponse heeloJson() {
        return new HelloResponse("Hello, Spring!", 200);
    }
}

record HelloResponse(String message, int code) {}
