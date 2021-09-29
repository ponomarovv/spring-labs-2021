package com.example.spring.repository.implementation;

import com.example.spring.model.Team;
import com.example.spring.repository.abstraction.GenericRepository;
import com.example.spring.repository.abstraction.ITeamRepository;
import org.springframework.stereotype.Repository;

@Repository
public class TeamRepository extends GenericRepository<Team, Integer> implements ITeamRepository {

    public TeamRepository() {
        entities.put(1, new Team(1, "Gryffindor"));
        entities.put(2, new Team(2, "Hufflepuff"));
        entities.put(3, new Team(3, "Ravenclaw"));
        entities.put(4, new Team(4, "Slytherin"));
        entities.put(5, new Team(5, "Tigers"));
    }
}
