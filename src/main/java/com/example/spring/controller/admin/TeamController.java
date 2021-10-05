package com.example.spring.controller.admin;

import com.example.spring.controller.BaseController;
import com.example.spring.model.Team;
import com.example.spring.processor.abstraction.IFieldErrorProcessor;
import com.example.spring.service.abstraction.IGameService;
import com.example.spring.service.abstraction.ITeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin/teams")
public class TeamController extends BaseController {

    private final ITeamService teamService;
    private final IGameService gameService;
    private final IFieldErrorProcessor fieldErrorProcessor;

    @Autowired
    public TeamController(ITeamService teamService, IGameService gameService, IFieldErrorProcessor fieldErrorProcessor) {
        this.teamService = teamService;
        this.gameService = gameService;
        this.fieldErrorProcessor = fieldErrorProcessor;
    }

    @PostMapping("")
    public String createTeam(@Valid @ModelAttribute Team team, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", fieldErrorProcessor.extractErrorMessages(bindingResult));
            model.addAttribute("teams", teamService.getAll());
            model.addAttribute("team", team);
            return render("team/index");
        }
        teamService.create(team);
        return "redirect:/admin/teams";
    }

    @GetMapping("")
    public String getAllTeams(Model model) {
        model.addAttribute("teams", teamService.getAll());
        return render("team/index");
    }

    @PostMapping("/update/{id}")
    public String updateTeam(@Valid @ModelAttribute Team team, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", fieldErrorProcessor.extractErrorMessages(bindingResult));
            model.addAttribute("team", team);
            return render("team/update");
        }
        teamService.update(team);
        return "redirect:/admin/teams";
    }

    @GetMapping("/update/{id}")
    public String showUpdateTeamPage(@PathVariable int id, Model model) {
        model.addAttribute("team", teamService.get(id));
        return render("team/update");
    }

    @PostMapping("/delete/{id}")
    public String deleteTeam(@PathVariable int id) {
        teamService.delete(id);
        gameService.deleteByTeamId(id);
        return "redirect:/admin/teams";
    }
}
