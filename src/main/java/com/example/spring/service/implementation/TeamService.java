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
    public void createTeam(Team team) {
        teamRepository.create(team);
    }

    @Override
    public Team get(int id) {
        return teamRepository.read(id);
    }

    @Override
    public List<Team> getAllTeams() {
        return teamRepository.readAll();
    }

    @Override
    public void updateTeam(Team team) {
        teamRepository.update(team);
    }

    @Override
    public void deleteTeam(int teamId) {
        teamRepository.delete(teamId);
    }
}
