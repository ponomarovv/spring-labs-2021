package com.example.spring.controller.admin;

import com.example.spring.controller.BaseController;
import com.example.spring.model.Sport;
import com.example.spring.resolver.abstraction.IFieldErrorResolver;
import com.example.spring.service.abstraction.ISportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    public ModelAndView createSport(@Valid @ModelAttribute Sport sport, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            ModelAndView mav = render("sport/index");
            mav.addObject("errors", fieldErrorResolver.extractErrorMessages(bindingResult));
            mav.addObject("sports", sportService.getAll());
            mav.addObject("sport", sport);
            return mav;
        }
        sportService.create(sport);
        return redirect("/admin/sports");
    }

    @GetMapping("")
    public ModelAndView getAllSports() {
        ModelAndView mav = render("sport/index");
        mav.addObject("sports", sportService.getAll());
        return mav;
    }

    @PostMapping("/update/{id}")
    public ModelAndView updateSport(@Valid @ModelAttribute Sport sport, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            ModelAndView mav = render("sport/update");
            mav.addObject("errors", fieldErrorResolver.extractErrorMessages(bindingResult));
            mav.addObject("sport", sport);
            return mav;
        }
        sportService.update(sport);
        return redirect("/admin/sports");
    }

    @GetMapping("/update/{id}")
    public ModelAndView showUpdateSportPage(@PathVariable int id) {
        ModelAndView mav = render("sport/update");
        mav.addObject("sport", sportService.get(id));
        return mav;
    }

    @PostMapping("/delete/{id}")
    public ModelAndView deleteSport(@PathVariable int id) {
        sportService.delete(id);
        return redirect("/admin/sports");
    }
}
