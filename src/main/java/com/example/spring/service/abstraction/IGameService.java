package com.example.spring.service.abstraction;

import com.example.spring.model.Game;

import java.util.List;

public interface IGameService extends ICrudService<Game, Integer> {

    List<Game> getAllByTeamNameLike(String name);

    void deleteBySportId(int sportId);

    void deleteByTeamId(int teamId);
}
