package com.example.spring.repository.implementation;

import com.example.spring.entity.Sport;
import com.example.spring.repository.abstraction.GenericRepository;
import com.example.spring.repository.abstraction.IGameRepository;
import com.example.spring.repository.abstraction.ISportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SportRepository extends GenericRepository<Sport, Integer> implements ISportRepository {

    @Autowired
    private IGameRepository gameRepository;

    public SportRepository() {
        Sport sport;
        sport = new Sport("Football");
        entities.put(sport.getId(), sport);
        sport = new Sport("Volleyball");
        entities.put(sport.getId(), sport);
        sport = new Sport("Tennis");
        entities.put(sport.getId(), sport);
        sport = new Sport("Quidditch");
        entities.put(sport.getId(), sport);
    }

    @Override
    public void delete(Integer key) {
        gameRepository.deleteBySportId(key);
        super.delete(key);
    }
}
