package com.example.spring.model;

public class Team implements IModel<Integer> {

    private int id;

    private String name;

    public Team() {}

    public Team(int id, String name) {
        this.id = id;
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
