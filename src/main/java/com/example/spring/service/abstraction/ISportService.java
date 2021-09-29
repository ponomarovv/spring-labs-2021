package com.example.spring.service.abstraction;

import com.example.spring.model.Sport;

import java.util.List;

public interface ISportService {

    void createSport(Sport sport);

    Sport get(int id);

    List<Sport> getAllSports();

    void updateSport(Sport sport);

    void deleteSport(int sportId);
}
