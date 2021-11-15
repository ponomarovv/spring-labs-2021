package com.example.spring.rest.controller;

import com.example.spring.entity.Game;
import com.example.spring.model.Pageable;
import com.example.spring.service.abstraction.IGameService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/games")
@RequiredArgsConstructor
public class GameRestController {
    private final IGameService gameService;

    @GetMapping
    public List<Game> getAll(@RequestParam(value = "name", defaultValue = "") String name, Pageable pageable) {
        return gameService.getAllByTeamNameLike(name, pageable);
    }

    @GetMapping("/{id}")
    public Game get(@PathVariable int id) {
        return gameService.get(id);
    }

    @PostMapping
    public boolean add(@Valid Game game) {
        gameService.create(game);
        return true;
    }

    @PatchMapping("/update")
    public boolean update(@Valid Game game) {
        gameService.update(game);
        return true;
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable int id) {
        gameService.delete(id);
        return true;
    }
}
