package com.eo.demo.controller.person;

import com.eo.demo.dto.FindStudentRequestDto;
import com.eo.demo.dto.FindStudentResponseDto;
import com.eo.demo.service.person.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping(path = "/hello")
    public String hello() {
        return "hello";
    }

    @PostMapping(path = "/find-student")
    public FindStudentResponseDto findStudent(@RequestBody @Validated FindStudentRequestDto requestDto) {
        return studentService.findStudent(requestDto);
    }

}
