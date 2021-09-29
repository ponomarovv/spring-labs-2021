package com.example.spring.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class Game implements IModel<Integer> {

    private static int counter = 1;

    private int id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    private int sportId;

    private int firstTeamId;

    private int secondTeamId;

    private int firstTeamScore;

    private int secondTeamScore;

    private Sport sport;

    private Team firstTeam;

    private Team secondTeam;

    public Game() {
        this.id = counter;
        counter++;
    }

    public Game(LocalDate date, int sportId, int firstTeamId, int secondTeamId, int firstTeamScore, int secondTeamScore) {
        this();

        this.date = date;
        this.sportId = sportId;
        this.firstTeamId = firstTeamId;
        this.secondTeamId = secondTeamId;
        this.firstTeamScore = firstTeamScore;
        this.secondTeamScore = secondTeamScore;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getSportId() {
        return sportId;
    }

    public void setSportId(int sportId) {
        this.sportId = sportId;
    }

    public int getFirstTeamId() {
        return firstTeamId;
    }

    public void setFirstTeamId(int firstTeamId) {
        this.firstTeamId = firstTeamId;
    }

    public int getSecondTeamId() {
        return secondTeamId;
    }

    public void setSecondTeamId(int secondTeamId) {
        this.secondTeamId = secondTeamId;
    }

    public int getFirstTeamScore() {
        return firstTeamScore;
    }

    public void setFirstTeamScore(int firstTeamScore) {
        this.firstTeamScore = firstTeamScore;
    }

    public int getSecondTeamScore() {
        return secondTeamScore;
    }

    public void setSecondTeamScore(int secondTeamScore) {
        this.secondTeamScore = secondTeamScore;
    }

    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }

    public Team getFirstTeam() {
        return firstTeam;
    }

    public void setFirstTeam(Team firstTeam) {
        this.firstTeam = firstTeam;
    }

    public Team getSecondTeam() {
        return secondTeam;
    }

    public void setSecondTeam(Team secondTeam) {
        this.secondTeam = secondTeam;
    }
}
