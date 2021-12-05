package com.example.spring.repository.implementation;

import com.example.spring.entity.Sport;
import com.example.spring.repository.abstraction.ISportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class SportRepository implements ISportRepository {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public Integer create(Sport sport) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO sports(name) VALUES (?)", new String[]{"id"});
            ps.setString(1, sport.getName());

            return ps;
        }, keyHolder);
        return keyHolder.getKey() == null ? null : keyHolder.getKey().intValue();
    }

    @Override
    public Sport read(Integer key) {
        return jdbcTemplate.queryForObject("SELECT * FROM sports WHERE id=?", BeanPropertyRowMapper.newInstance(Sport.class), key);
    }

    @Override
    public boolean update(Sport sport) {
        return jdbcTemplate.update("UPDATE sports SET name=? WHERE id=?", sport.getName(), sport.getId()) > 0;
    }

    @Override
    public void delete(Integer key) {
        jdbcTemplate.update("DELETE FROM sports where id=?", key);
    }

    @Override
    public List<Sport> readAll() {
        return jdbcTemplate.query("SELECT * FROM sports", BeanPropertyRowMapper.newInstance(Sport.class));
    }
}
