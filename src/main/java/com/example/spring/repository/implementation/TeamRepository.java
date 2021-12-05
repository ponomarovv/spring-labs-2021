package com.example.spring.repository.implementation;

import com.example.spring.entity.Team;
import com.example.spring.repository.abstraction.ITeamRepository;
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
public class TeamRepository implements ITeamRepository {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public Integer create(Team team) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO teams(name) VALUES (?)", new String[]{"id"});
            ps.setString(1, team.getName());

            return ps;
        }, keyHolder);
        return keyHolder.getKey() == null ? null : keyHolder.getKey().intValue();
    }

    @Override
    public Team read(Integer key) {
        return jdbcTemplate.queryForObject("SELECT * FROM teams WHERE id=?", BeanPropertyRowMapper.newInstance(Team.class), key);
    }

    @Override
    public boolean update(Team team) {
        return jdbcTemplate.update("UPDATE teams SET name=? WHERE id=?", team.getName(), team.getId()) > 0;
    }

    @Override
    public void delete(Integer key) {
        jdbcTemplate.update("DELETE FROM teams where id=?", key);
    }

    @Override
    public List<Team> readAll() {
        return jdbcTemplate.query("SELECT * FROM teams", BeanPropertyRowMapper.newInstance(Team.class));
    }
}
