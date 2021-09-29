package com.example.spring.model;

public class Sport implements IModel<Integer> {

    private static int counter = 1;

    private int id;

    private String name;

    public Sport() {
        this.id = counter;
        counter++;
    }

    public Sport(String name) {
        this();

        this.name = name;
    }

    @Override
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
