package com.example.spring.config;

import com.example.spring.repository.abstraction.IGameRepository;
import com.example.spring.service.abstraction.IGameService;
import com.example.spring.service.implementation.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class Beans {

    @Autowired
    private IGameRepository gameRepository;

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public IGameService getGameService() {
        return new GameService(gameRepository);
    }
}
