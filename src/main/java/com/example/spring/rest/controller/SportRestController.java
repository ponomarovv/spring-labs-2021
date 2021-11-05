package com.example.spring.rest.controller;

import com.example.spring.model.Sport;
import com.example.spring.service.abstraction.ISportService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/sports")
@RequiredArgsConstructor
public class SportRestController {
    private final ISportService sportService;

    @GetMapping
    public List<Sport> getAll() {
        return sportService.getAll();
    }

    @GetMapping("/{id}")
    public Sport get(@PathVariable int id) {
        return sportService.get(id);
    }

    @PostMapping
    public boolean add(@Valid Sport sport) {
        sportService.create(sport);
        return true;
    }

    @PatchMapping("/update")
    public boolean update(@Valid Sport sport) {
        sportService.update(sport);
        return true;
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable int id) {
        sportService.delete(id);
        return true;
    }
}
