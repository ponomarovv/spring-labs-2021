package com.example.spring.resolver.implementation;

import com.example.spring.resolver.abstraction.IPermissionResolver;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

@Component
public class PermissionResolver implements IPermissionResolver {

    @Override
    public boolean checkPermission(String role, String url, HttpMethod httpMethod) {
        if (url != null && (url.startsWith("/js") || url.startsWith("/css"))) {
            return true;
        }
        if ("/".equals(url)) {
            return true;
        }
        if ("/login".equals(url) && !"admin".equals(role)) {
            return true;
        }
        return url != null && url.startsWith("/admin") && "admin".equals(role);
    }
}
