package com.example.spring.resolver.implementation;

import com.example.spring.resolver.abstraction.IPermissionResolver;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

@Component
public class PermissionResolver implements IPermissionResolver {

    @Override
    public boolean checkPermission(String role, String url, HttpMethod httpMethod) {
        System.out.println("Url: " + url);
        if (url == null) {
            return false;
        }
        if (url.startsWith("/api")) {
            return true;
        }
        if (url.startsWith("/js") || url.startsWith("/css")) {
            return true;
        }
        if ("/".equals(url) && "admin".equals(role)) {
            return true;
        }
        if ("/".equals(url) && httpMethod.matches("GET")) {
            return true;
        }
        if ("/login".equals(url) && !"admin".equals(role)) {
            return true;
        }
        return url != null && url.startsWith("/admin") && "admin".equals(role);
    }
}
