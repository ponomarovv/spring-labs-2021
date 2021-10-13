package com.example.spring.controller;

import com.example.spring.service.abstraction.IGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController extends BaseController {

    private IGameService gameService;

    @Autowired
    public HomeController(IGameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("")
    public ModelAndView getAllGames(@RequestParam(name = "team-name", required = false, defaultValue = "") String teamName) {
        ModelAndView mav = render("index");
        mav.addObject("games", gameService.getAllByTeamNameLike(teamName));
        mav.addObject("teamName", teamName);
        return mav;
    }
}
