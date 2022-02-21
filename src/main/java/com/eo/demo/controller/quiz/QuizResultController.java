package com.eo.demo.controller.quiz;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/quiz-result")
@RequiredArgsConstructor
public class QuizResultController {

    @GetMapping(path = "/hello")
    public String hello() {
        return "hello";
    }

}
