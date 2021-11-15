package com.example.spring.controller.admin;

import com.example.spring.controller.BaseController;
import com.example.spring.entity.Team;
import com.example.spring.resolver.abstraction.IFieldErrorResolver;
import com.example.spring.service.abstraction.ITeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    public ModelAndView createTeam(@Valid @ModelAttribute Team team, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            ModelAndView mav = render("team/index");
            mav.addObject("errors", fieldErrorResolver.extractErrorMessages(bindingResult));
            mav.addObject("teams", teamService.getAll());
            mav.addObject("team", team);
            return mav;
        }
        teamService.create(team);
        return redirect("/admin/teams");
    }

    @GetMapping("")
    public ModelAndView getAllTeams() {
        ModelAndView mav = render("team/index");
        mav.addObject("teams", teamService.getAll());
        return mav;
    }

    @PostMapping("/update/{id}")
    public ModelAndView updateTeam(@Valid @ModelAttribute Team team, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            ModelAndView mav = render("team/update");
            mav.addObject("errors", fieldErrorResolver.extractErrorMessages(bindingResult));
            mav.addObject("team", team);
            return mav;
        }
        teamService.update(team);
        return redirect("/admin/teams");
    }

    @GetMapping("/update/{id}")
    public ModelAndView showUpdateTeamPage(@PathVariable int id) {
        ModelAndView mav = render("team/update");
        mav.addObject("team", teamService.get(id));
        return mav;
    }

    @PostMapping("/delete/{id}")
    public ModelAndView deleteTeam(@PathVariable int id) {
        teamService.delete(id);
        return redirect("/admin/teams");
    }
}
