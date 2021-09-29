package com.example.spring.controller.admin;

import com.example.spring.controller.BaseController;
import com.example.spring.model.Team;
import com.example.spring.service.abstraction.ITeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/teams")
public class TeamController extends BaseController {

    private final ITeamService teamService;

    @Autowired
    public TeamController(ITeamService teamService) {
        this.teamService = teamService;
    }

    @PostMapping("")
    public String createTeam(@ModelAttribute Team team) {
        teamService.createTeam(team);
        return "redirect:/admin/teams";
    }

    @GetMapping("")
    public String getAllTeams(Model model) {
        model.addAttribute("teams", teamService.getAllTeams());
        return render("team/index");
    }

    @PostMapping("/update/{id}")
    public String updateTeam(@ModelAttribute Team team) {
        teamService.updateTeam(team);
        return "redirect:/admin/teams";
    }

    @GetMapping("/update/{id}")
    public String showUpdateTeamPage(@PathVariable int id, Model model) {
        model.addAttribute("team", teamService.get(id));
        return render("team/update");
    }

    @PostMapping("/delete/{id}")
    public String deleteTeam(@PathVariable int id) {
        teamService.deleteTeam(id);
        return "redirect:/admin/teams";
    }
}
