package com.example.spring.interceptor;

import com.example.spring.resolver.abstraction.IPermissionResolver;
import com.example.spring.resolver.abstraction.IRequestResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class RoleInterceptor implements HandlerInterceptor {

    private final IRequestResolver requestResolver;
    private final IPermissionResolver permissionResolver;

    @Autowired
    public RoleInterceptor(IRequestResolver requestResolver, IPermissionResolver permissionResolver) {
        this.requestResolver = requestResolver;
        this.permissionResolver = permissionResolver;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String role = (String) request.getSession().getAttribute("role");
        String url = requestResolver.getPath(request);
        HttpMethod httpMethod = HttpMethod.valueOf(request.getMethod());
        if (!permissionResolver.checkPermission(role, url, httpMethod)) {
            response.sendRedirect("/login");
            return false;
        }
        return true;
    }
}
