package com.example.spring.controller.admin;

import com.example.spring.controller.BaseController;
import com.example.spring.model.Sport;
import com.example.spring.service.abstraction.IGameService;
import com.example.spring.service.abstraction.ISportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/sports")
public class SportController extends BaseController {

    private final ISportService sportService;
    private final IGameService gameService;

    @Autowired
    public SportController(ISportService sportService, IGameService gameService) {
        this.sportService = sportService;
        this.gameService = gameService;
    }

    @PostMapping("")
    public String createSport(@ModelAttribute Sport sport) {
        sportService.create(sport);
        return "redirect:/admin/sports";
    }

    @GetMapping("")
    public String getAllSports(Model model) {
        model.addAttribute("sports", sportService.getAll());
        return render("sport/index");
    }

    @PostMapping("/update/{id}")
    public String updateSport(@ModelAttribute Sport sport) {
        sportService.update(sport);
        return "redirect:/admin/sports";
    }

    @GetMapping("/update/{id}")
    public String showUpdateSportPage(@PathVariable int id, Model model) {
        model.addAttribute("sport", sportService.get(id));
        return render("sport/update");
    }

    @PostMapping("/delete/{id}")
    public String deleteSport(@PathVariable int id) {
        sportService.delete(id);
        gameService.deleteBySportId(id);
        return "redirect:/admin/sports";
    }
}
