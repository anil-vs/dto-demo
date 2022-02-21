package com.eo.demo.service.quiz;

import com.eo.demo.entity.quiz.QuizResult;
import com.eo.demo.repository.quiz.QuizResultRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuizResultService {

    private final QuizResultRepository quizResultRepository;

    public List<QuizResult> findByStudentId(long studentId) {
        return findByStudentId(studentId, false);
    }

    public List<QuizResult> findByStudentId(long studentId, boolean hideLowScores) {
        List<QuizResult> results = quizResultRepository.findByStudentId(studentId);

        if (hideLowScores) {
            results.removeIf(result -> result.getScore() < 20);
        }

        return results;
    }

}
