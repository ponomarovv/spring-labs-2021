package com.example.spring.controller.admin;

import com.example.spring.controller.BaseController;
import com.example.spring.model.Game;
import com.example.spring.resolver.abstraction.IFieldErrorResolver;
import com.example.spring.service.abstraction.IGameService;
import com.example.spring.service.abstraction.ISportService;
import com.example.spring.service.abstraction.ITeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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
    public ModelAndView createGame(@Valid @ModelAttribute Game game, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            ModelAndView mav = render("game/update");
            mav.addObject("errors", fieldErrorResolver.extractErrorMessages(bindingResult));
            mav.addObject("game", game);
            addRelationalData(mav);
            return mav;
        }
        game.setId(new Game().getId());
        gameService.create(game);
        return redirect("/");
    }

    @GetMapping("")
    public ModelAndView createGamePage() {
        ModelAndView mav = render("game/update");
        addRelationalData(mav);
        return mav;
    }

    @PostMapping("/update/{id}")
    public ModelAndView updateGame(@Valid @ModelAttribute Game game, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            ModelAndView mav = render("game/update");
            mav.addObject("errors", fieldErrorResolver.extractErrorMessages(bindingResult));
            mav.addObject("game", game);
            addRelationalData(mav);
            return mav;
        }
        gameService.update(game);
        return redirect("/");
    }

    @GetMapping("/update/{id}")
    public ModelAndView showUpdateGamePage(@PathVariable int id) {
        ModelAndView mav = render("game/update");
        mav.addObject("game", gameService.get(id));
        mav.addObject("sports", sportService.getAll());
        mav.addObject("teams", teamService.getAll());
        return mav;
    }

    @PostMapping("/delete/{id}")
    public ModelAndView deleteGame(@PathVariable int id) {
        gameService.delete(id);
        return redirect("/");
    }

    private void addRelationalData(ModelAndView mav) {
        mav.addObject("sports", sportService.getAll());
        mav.addObject("teams", teamService.getAll());
    }
}
