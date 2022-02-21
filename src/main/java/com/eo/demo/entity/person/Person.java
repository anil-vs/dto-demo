package com.eo.demo.entity.person;

import lombok.Data;

import javax.persistence.*;

@Data
@MappedSuperclass
public abstract class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer age;

}
