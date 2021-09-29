package com.example.spring.controller;

public abstract class BaseController {

    protected String getLayout() {
        return "main";
    }

    protected String render(String page) {
        return render(getLayout(), page);
    }

    protected String render(String layout, String page) {
        return "layouts/main/" + layout + " :: view(page='views/" + page + "')";
    }
}
