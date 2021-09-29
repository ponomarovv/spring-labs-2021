package com.example.spring.repository.implementation;

import com.example.spring.model.Sport;
import com.example.spring.repository.abstraction.GenericRepository;
import com.example.spring.repository.abstraction.ISportRepository;
import org.springframework.stereotype.Repository;

@Repository
public class SportRepository extends GenericRepository<Sport, Integer> implements ISportRepository {

    public SportRepository() {
        entities.put(1, new Sport(1, "Football"));
        entities.put(2, new Sport(2, "Volleyball"));
        entities.put(3, new Sport(3, "Tennis"));
        entities.put(4, new Sport(4, "Quidditch"));
    }
}
