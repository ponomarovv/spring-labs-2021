package com.example.spring.resolver.abstraction;

import javax.servlet.http.HttpServletRequest;

public interface IRequestResolver {

    String getPath(HttpServletRequest request);
}
