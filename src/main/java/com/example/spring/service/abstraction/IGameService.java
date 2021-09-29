package com.example.spring.service.abstraction;

import com.example.spring.model.Game;

import java.util.List;

public interface IGameService {

    List<Game> getAllWithTeamsAndSport();
}
