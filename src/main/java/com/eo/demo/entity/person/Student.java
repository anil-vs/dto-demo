package com.eo.demo.entity.person;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Student extends Person {

    private Double gpa;

}
