package com.example.spring.repository.implementation;

import com.example.spring.model.Sport;
import com.example.spring.repository.abstraction.GenericRepository;
import com.example.spring.repository.abstraction.ISportRepository;
import org.springframework.stereotype.Repository;

@Repository
public class SportRepository extends GenericRepository<Sport, Integer> implements ISportRepository {
}
