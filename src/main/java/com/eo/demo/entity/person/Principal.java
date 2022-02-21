package com.eo.demo.entity.person;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("P")
public class Principal extends Teacher {

    @Override
    public int getWage() {
        return 2000;
    }

}
