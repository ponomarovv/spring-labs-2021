package com.example.spring.service.implementation;

import com.example.spring.model.Team;
import com.example.spring.repository.abstraction.ITeamRepository;
import com.example.spring.service.abstraction.ITeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService implements ITeamService {

    private final ITeamRepository teamRepository;

    @Autowired
    public TeamService(ITeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Override
    public void create(Team team) {
        teamRepository.create(team);
    }

    @Override
    public Team get(Integer id) {
        return teamRepository.read(id);
    }

    @Override
    public List<Team> getAll() {
        return teamRepository.readAll();
    }

    @Override
    public void update(Team team) {
        teamRepository.update(team);
    }

    public void delete(Integer teamId) {
        teamRepository.delete(teamId);
    }
}
