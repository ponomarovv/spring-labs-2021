package com.example.spring.service.implementation;

import com.example.spring.config.AdminData;
import com.example.spring.service.abstraction.IAuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements IAuthService {

    @Override
    public boolean loginAdmin(String login, String password) {
        return AdminData.LOGIN.equals(login) && AdminData.PASSWORD.equals(password);
    }
}
