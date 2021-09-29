package com.example.spring.repository.implementation;

import com.example.spring.model.Team;
import com.example.spring.repository.abstraction.GenericRepository;
import com.example.spring.repository.abstraction.ITeamRepository;
import org.springframework.stereotype.Repository;

@Repository
public class TeamRepository extends GenericRepository<Team, Integer> implements ITeamRepository {

    public TeamRepository() {
        Team team;
        team = new Team("Gryffindor");
        entities.put(team.getId(), team);
        team = new Team("Hufflepuff");
        entities.put(team.getId(), team);
        team = new Team("Ravenclaw");
        entities.put(team.getId(), team);
        team = new Team("Slytherin");
        entities.put(team.getId(), team);
        team = new Team("Tigers");
        entities.put(team.getId(), team);
    }
}
