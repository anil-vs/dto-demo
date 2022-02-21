package com.eo.demo.entity.quiz;

import com.eo.demo.entity.person.Teacher;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @OneToMany
    @JoinColumn(name = "quiz_id")
    private List<QuizResult> results;

}
