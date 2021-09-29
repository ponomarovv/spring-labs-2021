package com.example.spring.service.implementation;

import com.example.spring.model.Sport;
import com.example.spring.repository.abstraction.ISportRepository;
import com.example.spring.service.abstraction.ISportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SportService implements ISportService {

    private final ISportRepository sportRepository;

    @Autowired
    public SportService(ISportRepository sportRepository) {
        this.sportRepository = sportRepository;
    }

    @Override
    public void createSport(Sport sport) {
        sportRepository.create(sport);
    }

    @Override
    public Sport get(int id) {
        return sportRepository.read(id);
    }

    @Override
    public List<Sport> getAllSports() {
        return sportRepository.readAll();
    }

    @Override
    public void updateSport(Sport sport) {
        sportRepository.update(sport);
    }

    @Override
    public void deleteSport(int sportId) {
        sportRepository.delete(sportId);
    }
}
