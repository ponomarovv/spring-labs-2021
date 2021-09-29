package com.example.spring;

import com.example.spring.service.abstraction.IGameService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GameController {

    private final IGameService gameService;

    public GameController(IGameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("/")
    public String getAllGames(Model model) {
        model.addAttribute("games", gameService.getAllWithTeamsAndSport());
        return "index";
    }
}
