package com.eo.demo.entity.person;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
public abstract class Teacher extends Person {

    @Enumerated(EnumType.STRING)
    private Branch branch;

    public abstract int getWage();

}
