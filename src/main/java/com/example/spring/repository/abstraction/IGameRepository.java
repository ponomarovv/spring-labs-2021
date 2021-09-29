package com.example.spring.repository.abstraction;

import com.example.spring.model.Game;

import java.util.List;

public interface IGameRepository extends IGenericRepository<Game, Integer> {

    List<Game> findAllWithTeamsAndSport();

    List<Game> findAllByTeamName(String teamName);
}
