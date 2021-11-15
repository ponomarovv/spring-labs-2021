package com.example.spring.service.abstraction;

import com.example.spring.entity.Game;
import com.example.spring.model.Pageable;

import java.util.List;

public interface IGameService extends ICrudService<Game, Integer> {

    List<Game> getAllByTeamNameLike(String name);

    List<Game> getAllByTeamNameLike(String name, Pageable pageable);
}
