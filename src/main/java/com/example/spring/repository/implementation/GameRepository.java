package com.example.spring.repository.implementation;

import com.example.spring.model.Game;
import com.example.spring.repository.abstraction.GenericRepository;
import com.example.spring.repository.abstraction.IGameRepository;
import com.example.spring.repository.abstraction.ISportRepository;
import com.example.spring.repository.abstraction.ITeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class GameRepository extends GenericRepository<Game, Integer> implements IGameRepository {

    @Autowired
    private ITeamRepository teamRepository;

    @Autowired
    private ISportRepository sportRepository;

    @Autowired
    public GameRepository() {
        Game game;
        game = new Game(LocalDate.of(2020, Month.JANUARY, 12), 1, 1, 2, 0, 0);
        entities.put(game.getId(), game);
        game = new Game(LocalDate.of(2020, Month.FEBRUARY, 15), 1, 3, 4, 1, 0);
        entities.put(game.getId(), game);
        game = new Game(LocalDate.of(2020, Month.MARCH, 18), 2, 5, 4, 2, 1);
        entities.put(game.getId(), game);
        game = new Game(LocalDate.of(2020, Month.MAY, 4), 3, 3, 2, 1, 3);
        entities.put(game.getId(), game);
        game = new Game(LocalDate.of(2020, Month.APRIL, 7), 2, 5, 1, 2, 2);
        entities.put(game.getId(), game);
    }

    @Override
    public List<Game> findAllWithTeamsAndSports() {
        return entities.values().stream()
            .peek(game -> {
                game.setSport(sportRepository.read(game.getSportId()));
                game.setFirstTeam(teamRepository.read(game.getFirstTeamId()));
                game.setSecondTeam(teamRepository.read(game.getSecondTeamId()));
            }).collect(Collectors.toList());
    }

    @Override
    public List<Game> findAllByTeamName(String teamName) {
        return findAllWithTeamsAndSports().stream()
            .filter(game ->
                game.getFirstTeam().getName().toLowerCase().contains(teamName.toLowerCase()) ||
                game.getSecondTeam().getName().toLowerCase().contains(teamName.toLowerCase()))
            .collect(Collectors.toList());
    }

    @Override
    public void deleteBySportId(int sportId) {
        entities = entities.values().stream()
            .filter(game -> game.getSportId() != sportId)
            .collect(Collectors.toMap(Game::getId, game -> game));
    }

    @Override
    public void deleteByTeamId(int teamId) {
        entities = entities.values().stream()
            .filter(game -> game.getFirstTeamId() != teamId && game.getSecondTeamId() != teamId)
            .collect(Collectors.toMap(Game::getId, game -> game));
    }
}
