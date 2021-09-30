package com.example.spring.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Team implements IModel<Integer> {

    private static int counter = 1;

    private int id;

    @NotNull
    @Size(min=3, message = "The 'name' field must have at least {min} characters")
    private String name;

    public Team() {
        this.id = counter;
        counter++;
    }

    public Team(String name) {
        this();

        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
