package com.eo.demo.service.quiz;

import com.eo.demo.entity.quiz.QuizResult;
import com.eo.demo.repository.quiz.QuizResultRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class QuizResultServiceTest {

    @InjectMocks
    private QuizResultService quizResultService;

    @Mock
    private QuizResultRepository quizResultRepository;

    @Test
    public void shouldFindAllResults() {
        // given
        List<QuizResult> results = Arrays.asList(
                new QuizResult(10),
                new QuizResult(50)
        );

        when(quizResultRepository.findByStudentId(anyLong()))
                .thenReturn(results);

        // when
        List<QuizResult> foundResults = quizResultService.findByStudentId(0L);

        // then
        assertEquals(foundResults.size(), results.size());
    }

    @Test
    public void shouldHideLowScores() {
        // given
        List<QuizResult> results = new ArrayList<>();
        results.add(new QuizResult(10));
        results.add(new QuizResult(50));

        when(quizResultRepository.findByStudentId(anyLong()))
                .thenReturn(results);

        // when
        List<QuizResult> foundResults = quizResultService.findByStudentId(0L, true);

        // then
        boolean lowScoreExists = foundResults
                .stream()
                .anyMatch(result -> result.getScore() < 20);

        assertFalse(lowScoreExists);
    }

}
