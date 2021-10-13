package com.example.spring.controller;

import org.springframework.web.servlet.ModelAndView;

public abstract class BaseController {

    protected String getLayout() {
        return "layouts/main/main";
    }

    protected ModelAndView render(String view) {
        return render(getLayout(), view);
    }

    protected ModelAndView render(String layout, String view) {
        ModelAndView mav = new ModelAndView(layout);
        mav.addObject("_view", view);
        return mav;
    }

    protected ModelAndView redirect(String page) {
        return new ModelAndView("redirect:" + page);
    }
}
