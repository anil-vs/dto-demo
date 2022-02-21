package com.eo.demo.service.person;

import com.eo.demo.dto.FindStudentRequestDto;
import com.eo.demo.dto.FindStudentResponseDto;
import com.eo.demo.entity.person.Student;
import com.eo.demo.entity.quiz.QuizResult;
import com.eo.demo.exception.NotFoundException;
import com.eo.demo.repository.person.StudentRepository;
import com.eo.demo.service.quiz.QuizResultService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @InjectMocks
    private StudentService studentService;

    @Mock
    private StudentRepository studentRepository;

    @Mock
    private QuizResultService quizResultService;

    @Test
    public void shouldFindStudent() {
        // given
        FindStudentRequestDto requestDto = FindStudentRequestDto
                .builder()
                .id(1L)
                .build();

        Student student = new Student();
        student.setName("anil");
        Optional<Student> optionalStudent = Optional.of(student);

        List<QuizResult> results = Arrays.asList(
                new QuizResult(10),
                new QuizResult(50)
        );

        when(studentRepository.findById(anyLong()))
                .thenReturn(optionalStudent);

        when(quizResultService.findByStudentId(anyLong()))
                .thenReturn(results);

        // when
        FindStudentResponseDto responseDto = studentService.findStudent(requestDto);

        // then
        assertEquals(responseDto.getName(), student.getName());
        assertEquals(responseDto.getResults().size(), results.size());
        verify(studentRepository).findById(requestDto.getId());
    }

    @Test
    public void shouldFailWhenStudentNotExists() {
        // given
        FindStudentRequestDto requestDto = FindStudentRequestDto
                .builder()
                .id(1L)
                .build();

        Optional<Student> optionalStudent = Optional.empty();

        when(studentRepository.findById(anyLong()))
                .thenReturn(optionalStudent);

        // when
        assertThrows(NotFoundException.class, () -> studentService.findStudent(requestDto));
    }

}
