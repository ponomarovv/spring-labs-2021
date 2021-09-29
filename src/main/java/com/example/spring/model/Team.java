package com.example.spring.model;

public class Team implements IModel<Integer> {

    private static int counter = 1;

    private int id;

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
