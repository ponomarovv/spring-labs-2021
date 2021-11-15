package com.example.spring.repository.abstraction;

import com.example.spring.entity.Game;
import com.example.spring.model.Pageable;

import java.util.List;

public interface IGameRepository extends IGenericRepository<Game, Integer> {

    List<Game> findAllWithTeamsAndSports();

    List<Game> findAllByTeamName(String teamName);

    List<Game> findAllByTeamName(String teamName, Pageable pageable);

    void deleteBySportId(int sportId);

    void deleteByTeamId(int teamId);
}
