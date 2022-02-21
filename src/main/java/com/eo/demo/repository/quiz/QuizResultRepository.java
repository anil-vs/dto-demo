package com.eo.demo.repository.quiz;

import com.eo.demo.entity.quiz.QuizResult;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizResultRepository extends CrudRepository<QuizResult, Long> {

    @Query("select qr " +
            "from QuizResult qr " +
            "where qr.student.id = :studentId")
    List<QuizResult> findByStudentId(Long studentId);

}
