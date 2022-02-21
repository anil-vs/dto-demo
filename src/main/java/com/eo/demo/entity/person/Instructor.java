package com.eo.demo.entity.person;

import com.eo.demo.entity.quiz.Quiz;
import com.eo.demo.interfaces.Questionable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("I")
public class Instructor extends Teacher implements Questionable {

    @Override
    public int getWage() {
        return 1500;
    }

    @Override
    public Quiz doQuiz() {
        Quiz quiz = new Quiz();
        quiz.setTeacher(this);
        return quiz;
    }

}
