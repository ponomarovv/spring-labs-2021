package com.example.spring.controller.admin;

import com.example.spring.controller.BaseController;
import com.example.spring.model.Sport;
import com.example.spring.resolver.abstraction.IFieldErrorResolver;
import com.example.spring.service.abstraction.ISportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin/sports")
public class SportController extends BaseController {

    private final ISportService sportService;
    private final IFieldErrorResolver fieldErrorResolver;

    @Autowired
    public SportController(ISportService sportService, IFieldErrorResolver fieldErrorResolver) {
        this.sportService = sportService;
        this.fieldErrorResolver = fieldErrorResolver;
    }

    @PostMapping("")
    public ModelAndView createSport(@Valid @ModelAttribute Sport sport, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", fieldErrorResolver.extractErrorMessages(bindingResult));
            model.addAttribute("sports", sportService.getAll());
            model.addAttribute("sport", sport);
            return render("sport/index");
        }
        sportService.create(sport);
        return redirect(":/admin/sports");
    }

    @GetMapping("")
    public ModelAndView getAllSports(Model model) {
        model.addAttribute("sports", sportService.getAll());
        return render("sport/index");
    }

    @PostMapping("/update/{id}")
    public ModelAndView updateSport(@Valid @ModelAttribute Sport sport, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", fieldErrorResolver.extractErrorMessages(bindingResult));
            model.addAttribute("sport", sport);
            return render("sport/update");
        }
        sportService.update(sport);
        return redirect("/admin/sports");
    }

    @GetMapping("/update/{id}")
    public ModelAndView showUpdateSportPage(@PathVariable int id, Model model) {
        model.addAttribute("sport", sportService.get(id));
        return render("sport/update");
    }

    @PostMapping("/delete/{id}")
    public ModelAndView deleteSport(@PathVariable int id) {
        sportService.delete(id);
        return redirect("/admin/sports");
    }
}
