package com.example.spring.resolver.abstraction;

import org.springframework.http.HttpMethod;

public interface IPermissionResolver {

    boolean checkPermission(String role, String url, HttpMethod httpMethod);
}
