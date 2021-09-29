package com.example.spring.repository.implementation;

import com.example.spring.model.Team;
import com.example.spring.repository.abstraction.GenericRepository;
import com.example.spring.repository.abstraction.ITeamRepository;
import org.springframework.stereotype.Repository;

@Repository
public class TeamRepository extends GenericRepository<Team, Integer> implements ITeamRepository {
}
