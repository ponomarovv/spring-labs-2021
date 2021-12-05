package com.example.spring.service.implementation;

import com.example.spring.entity.Sport;
import com.example.spring.repository.abstraction.IGameRepository;
import com.example.spring.repository.abstraction.ISportRepository;
import com.example.spring.service.abstraction.ISportService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SportService implements ISportService {

    private final ISportRepository sportRepository;
    private final IGameRepository gameRepository;

    @Override
    public Integer create(Sport sport) {
        return sportRepository.create(sport);
    }

    @Override
    public Sport get(Integer id) {
        return sportRepository.read(id);
    }

    @Override
    public List<Sport> getAll() {
        return sportRepository.readAll();
    }

    @Override
    public void update(Sport sport) {
        sportRepository.update(sport);
    }

    @Override
    @Transactional
    public void delete(Integer sportId) {
        gameRepository.deleteBySportId(sportId);
        sportRepository.delete(sportId);
    }
}
