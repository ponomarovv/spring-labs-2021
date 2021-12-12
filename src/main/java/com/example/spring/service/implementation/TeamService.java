package com.example.spring.service.implementation;

import com.example.spring.entity.Team;
import com.example.spring.repository.abstraction.IGameRepository;
import com.example.spring.repository.abstraction.ITeamRepository;
import com.example.spring.service.abstraction.ITeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamService implements ITeamService {

    private final ITeamRepository teamRepository;
    private final IGameRepository gameRepository;

    @Override
    public Integer create(Team team) {
        return teamRepository.create(team);
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

    @Override
    @Transactional
    public void delete(Integer teamId) {
        gameRepository.deleteByTeamId(teamId);
        teamRepository.delete(teamId);
    }
}
