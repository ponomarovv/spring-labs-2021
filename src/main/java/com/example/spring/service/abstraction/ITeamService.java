package com.example.spring.service.abstraction;

import com.example.spring.model.Team;

import java.util.List;

public interface ITeamService {

    void createTeam(Team team);

    Team get(int id);

    List<Team> getAllTeams();

    void updateTeam(Team team);

    void deleteTeam(int teamId);
}
