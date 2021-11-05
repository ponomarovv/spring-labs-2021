package com.example.spring.rest.controller;

import com.example.spring.model.Team;
import com.example.spring.service.abstraction.ITeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/teams")
@RequiredArgsConstructor
public class TeamRestController {
    private final ITeamService teamService;

    @GetMapping
    public List<Team> getAll() {
        return teamService.getAll();
    }

    @GetMapping("/{id}")
    public Team get(@PathVariable int id) {
        return teamService.get(id);
    }

    @PostMapping
    public boolean add(@Valid Team team) {
        teamService.create(team);
        return true;
    }

    @PatchMapping("/update")
    public boolean update(@Valid Team team) {
        teamService.update(team);
        return true;
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable int id) {
        teamService.delete(id);
        return true;
    }
}
