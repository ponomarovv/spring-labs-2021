package com.example.spring.config.abstraction;

import com.example.spring.config.Role;

public interface IRoleContext {

    Role getCurrentRole();

    void setCurrentRole(Role role);
}
