package com.eo.demo.service.person;

import com.eo.demo.dto.FindStudentRequestDto;
import com.eo.demo.dto.FindStudentResponseDto;
import com.eo.demo.entity.person.Student;
import com.eo.demo.entity.quiz.QuizResult;
import com.eo.demo.exception.NotFoundException;
import com.eo.demo.repository.person.StudentRepository;
import com.eo.demo.service.quiz.QuizResultService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final QuizResultService quizResultService;

    public FindStudentResponseDto findStudent(FindStudentRequestDto requestDto) {
        Long id = requestDto.getId();

        Student student = studentRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException(id));

        List<Integer> results = quizResultService
                .findByStudentId(id)
                .stream()
                .mapToInt(QuizResult::getScore)
                .boxed()
                .collect(Collectors.toList());

        return FindStudentResponseDto
                .builder()
                .name(student.getName())
                .results(results)
                .build();
    }

}
