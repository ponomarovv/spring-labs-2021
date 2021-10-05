package com.example.spring.controller.admin;

import com.example.spring.controller.BaseController;
import com.example.spring.model.Game;
import com.example.spring.resolver.abstraction.IFieldErrorResolver;
import com.example.spring.service.abstraction.IGameService;
import com.example.spring.service.abstraction.ISportService;
import com.example.spring.service.abstraction.ITeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin/games")
public class GameController extends BaseController {

    private final ISportService sportService;
    private final ITeamService teamService;
    private final IGameService gameService;
    private final IFieldErrorResolver fieldErrorResolver;

    @Autowired
    public GameController(ISportService sportService, ITeamService teamService, IGameService gameService, IFieldErrorResolver fieldErrorResolver) {
        this.sportService = sportService;
        this.teamService = teamService;
        this.gameService = gameService;
        this.fieldErrorResolver = fieldErrorResolver;
    }

    @PostMapping("")
    public String createGame(@Valid @ModelAttribute Game game, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", fieldErrorResolver.extractErrorMessages(bindingResult));
            model.addAttribute("game", game);
            addRelationalData(model);
            return render("game/update");
        }
        game.setId(new Game().getId());
        gameService.create(game);
        return "redirect:/";
    }

    @GetMapping("")
    public String createGamePage(Model model) {
        addRelationalData(model);
        return render("game/update");
    }

    @PostMapping("/update/{id}")
    public String updateGame(@Valid @ModelAttribute Game game, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", fieldErrorResolver.extractErrorMessages(bindingResult));
            model.addAttribute("game", game);
            addRelationalData(model);
            return render("game/update");
        }
        gameService.update(game);
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String showUpdateGamePage(@PathVariable int id, Model model) {
        model.addAttribute("game", gameService.get(id));
        model.addAttribute("sports", sportService.getAll());
        model.addAttribute("teams", teamService.getAll());
        return render("game/update");
    }

    @PostMapping("/delete/{id}")
    public String deleteGame(@PathVariable int id) {
        gameService.delete(id);
        return "redirect:/";
    }

    private void addRelationalData(Model model) {
        model.addAttribute("sports", sportService.getAll());
        model.addAttribute("teams", teamService.getAll());
    }
}
