package com.example.spring.repository.implementation;

import com.example.spring.model.Game;
import com.example.spring.repository.abstraction.GenericRepository;
import com.example.spring.repository.abstraction.IGameRepository;
import com.example.spring.repository.abstraction.ISportRepository;
import com.example.spring.repository.abstraction.ITeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class GameRepository extends GenericRepository<Game, Integer> implements IGameRepository {

    private final ITeamRepository teamRepository;
    private final ISportRepository sportRepository;

    @Autowired
    public GameRepository(ITeamRepository teamRepository, ISportRepository sportRepository) {
        this.teamRepository = teamRepository;
        this.sportRepository = sportRepository;
    }

    @Override
    public List<Game> findAllWithTeamsAndSport() {
        return entities.values().stream()
            .peek(game -> {
                game.setSport(sportRepository.read(game.getSportId()));
                game.setFirstTeam(teamRepository.read(game.getFirstTeamId()));
                game.setSecondTeam(teamRepository.read(game.getSecondTeamId()));
            }).collect(Collectors.toList());
    }

    @Override
    public List<Game> findAllByTeamName(String teamName) {
        return findAllWithTeamsAndSport().stream()
            .filter(game ->
                game.getFirstTeam().getName().toLowerCase().contains(teamName.toLowerCase()) ||
                game.getSecondTeam().getName().toLowerCase().contains(teamName.toLowerCase()))
            .collect(Collectors.toList());
    }
}
