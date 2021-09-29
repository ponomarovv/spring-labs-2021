package com.example.spring.service.implementation;

import com.example.spring.model.Game;
import com.example.spring.repository.abstraction.IGameRepository;
import com.example.spring.service.abstraction.IGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService implements IGameService {

    private final IGameRepository gameRepository;

    @Autowired
    public GameService(IGameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    public void create(Game game) {
        gameRepository.create(game);
    }

    @Override
    public Game get(Integer key) {
        return gameRepository.read(key);
    }

    @Override
    public List<Game> getAll() {
        return gameRepository.findAllWithTeamsAndSport();
    }

    @Override
    public void update(Game game) {
        gameRepository.update(game);
    }

    @Override
    public void delete(Integer key) {
        gameRepository.delete(key);
    }

    @Override
    public List<Game> getAllByTeamNameLike(String name) {
        return gameRepository.findAllByTeamName(name);
    }
}
