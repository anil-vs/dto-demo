package com.eo.demo.controller.person;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/teacher")
@RequiredArgsConstructor
public class TeacherController {

    @GetMapping(path = "/hello")
    public String hello() {
        return "hello";
    }

}
