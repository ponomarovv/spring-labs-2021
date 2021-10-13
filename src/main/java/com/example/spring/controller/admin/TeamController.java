package com.example.spring.controller.admin;

import com.example.spring.controller.BaseController;
import com.example.spring.model.Team;
import com.example.spring.resolver.abstraction.IFieldErrorResolver;
import com.example.spring.service.abstraction.ITeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin/teams")
public class TeamController extends BaseController {

    private final ITeamService teamService;
    private final IFieldErrorResolver fieldErrorResolver;

    @Autowired
    public TeamController(ITeamService teamService, IFieldErrorResolver fieldErrorResolver) {
        this.teamService = teamService;
        this.fieldErrorResolver = fieldErrorResolver;
    }

    @PostMapping("")
    public ModelAndView createTeam(@Valid @ModelAttribute Team team, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", fieldErrorResolver.extractErrorMessages(bindingResult));
            model.addAttribute("teams", teamService.getAll());
            model.addAttribute("team", team);
            return render("team/index");
        }
        teamService.create(team);
        return redirect("/admin/teams");
    }

    @GetMapping("")
    public ModelAndView getAllTeams(Model model) {
        model.addAttribute("teams", teamService.getAll());
        return render("team/index");
    }

    @PostMapping("/update/{id}")
    public ModelAndView updateTeam(@Valid @ModelAttribute Team team, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", fieldErrorResolver.extractErrorMessages(bindingResult));
            model.addAttribute("team", team);
            return render("team/update");
        }
        teamService.update(team);
        return redirect("/admin/teams");
    }

    @GetMapping("/update/{id}")
    public ModelAndView showUpdateTeamPage(@PathVariable int id, Model model) {
        model.addAttribute("team", teamService.get(id));
        return render("team/update");
    }

    @PostMapping("/delete/{id}")
    public ModelAndView deleteTeam(@PathVariable int id) {
        teamService.delete(id);
        return redirect("/admin/teams");
    }
}
