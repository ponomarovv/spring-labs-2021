package com.example.spring.resolver.implementation;

import com.example.spring.resolver.abstraction.IRequestResolver;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class RequestResolver implements IRequestResolver {

    @Override
    public String getPath(HttpServletRequest request) {
        return request.getRequestURI().substring(request.getContextPath().length());
    }
}
