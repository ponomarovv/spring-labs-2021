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

    private final ITeamRepository teamRepository;
    private final ISportRepository sportRepository;

    @Autowired
    public GameRepository(ITeamRepository teamRepository, ISportRepository sportRepository) {
        this.teamRepository = teamRepository;
        this.sportRepository = sportRepository;

        entities.put(1, new Game(1, LocalDate.of(2020, Month.JANUARY, 12), 1, 1, 2, 0, 0));
        entities.put(2, new Game(2, LocalDate.of(2020, Month.FEBRUARY, 15), 1, 3, 4, 1, 0));
        entities.put(3, new Game(3, LocalDate.of(2020, Month.MARCH, 18), 2, 5, 4, 2, 1));
        entities.put(4, new Game(4, LocalDate.of(2020, Month.MAY, 4), 3, 3, 2, 1, 3));
        entities.put(5, new Game(5, LocalDate.of(2020, Month.APRIL, 7), 2, 5, 1, 2, 2));
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
