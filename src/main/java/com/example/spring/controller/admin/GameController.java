package com.example.spring.controller.admin;

import com.example.spring.controller.BaseController;
import com.example.spring.model.Game;
import com.example.spring.model.Sport;
import com.example.spring.service.abstraction.IGameService;
import com.example.spring.service.abstraction.ISportService;
import com.example.spring.service.abstraction.ITeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/games")
public class GameController extends BaseController {

    private final ISportService sportService;
    private final ITeamService teamService;
    private final IGameService gameService;

    @Autowired
    public GameController(ISportService sportService, ITeamService teamService, IGameService gameService) {
        this.sportService = sportService;
        this.teamService = teamService;
        this.gameService = gameService;
    }

    @PostMapping("")
    public String createGame(@ModelAttribute Game game) {
        game.setId(new Game().getId());
        gameService.create(game);
        return "redirect:/";
    }

    @GetMapping("")
    public String createGamePage(Model model) {
        model.addAttribute("sports", sportService.getAll());
        model.addAttribute("teams", teamService.getAll());
        return render("game/update");
    }

    @PostMapping("/update/{id}")
    public String updateGame(@ModelAttribute Game game) {
        gameService.update(game);
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String showUpdateSportPage(@PathVariable int id, Model model) {
        model.addAttribute("game", gameService.get(id));
        model.addAttribute("sports", sportService.getAll());
        model.addAttribute("teams", teamService.getAll());
        return render("game/update");
    }

    @PostMapping("/delete/{id}")
    public String deleteSport(@PathVariable int id) {
        gameService.delete(id);
        return "redirect:/";
    }
}
