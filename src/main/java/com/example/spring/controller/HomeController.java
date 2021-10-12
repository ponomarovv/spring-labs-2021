package com.example.spring.controller;

import com.example.spring.service.abstraction.IGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController extends BaseController {

    private IGameService gameService;

    @GetMapping("")
    public String getAllGames(@RequestParam(name = "team-name", required = false, defaultValue = "") String teamName, Model model) {
        model.addAttribute("games", gameService.getAllByTeamNameLike(teamName));
        model.addAttribute("teamName", teamName);
        return "main";
    }

    @Autowired
    public void setGameService(IGameService gameService) {
        this.gameService = gameService;
    }
}
