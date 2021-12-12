package com.example.spring.repository.implementation;

import com.example.spring.entity.Game;
import com.example.spring.model.Pageable;
import com.example.spring.repository.abstraction.IGameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class GameRepository implements IGameRepository {

    private static final String GAMES_WITH_SPORT_AND_TEAMS_QUERY =
            "SELECT " +
                "g.id, " +
                "g.date, " +
                "g.sport_id, " +
                "g.first_team_id, " +
                "g.second_team_id, " +
                "g.first_team_score, " +
                "g.second_team_score, " +
                "s.id AS sport_id, " +
                "s.name AS sport_name, " +
                "ft.id AS first_team_id, " +
                "ft.name AS first_team_name, " +
                "st.id AS second_team_id, " +
                "st.name AS second_team_name " +
            "FROM games g " +
                "LEFT JOIN sports s ON g.sport_id=s.id " +
                "LEFT JOIN teams ft ON g.first_team_id=ft.id " +
                "LEFT JOIN teams st ON g.second_team_id=st.id";
    private static final String GAMES_WITH_SPORT_AND_TEAMS_QUERY_BY_TEAM_NAME =
            GAMES_WITH_SPORT_AND_TEAMS_QUERY + " " +
            "WHERE ft.name ILIKE '%{teamName}%' OR st.name ILIKE '%{teamName}%'";
    private static final String GAMES_WITH_SPORT_AND_TEAMS_QUERY_BY_TEAM_NAME_PAGEABLE =
            GAMES_WITH_SPORT_AND_TEAMS_QUERY_BY_TEAM_NAME + " " +
            "LIMIT {limit} OFFSET {offset}";

    private final JdbcTemplate jdbcTemplate;
    private final ResultSetExtractor<List<Game>> gameWithSportAndTeamsExtractor;

    @Override
    public List<Game> findAllWithTeamsAndSports() {
        return jdbcTemplate.query(GAMES_WITH_SPORT_AND_TEAMS_QUERY, gameWithSportAndTeamsExtractor);
    }

    @Override
    public List<Game> findAllByTeamName(String teamName) {
        String query = GAMES_WITH_SPORT_AND_TEAMS_QUERY_BY_TEAM_NAME.replace("{teamName}", teamName);
        return jdbcTemplate.query(query, gameWithSportAndTeamsExtractor);
    }

    @Override
    public List<Game> findAllByTeamName(String teamName, Pageable pageable) {
        String query = GAMES_WITH_SPORT_AND_TEAMS_QUERY_BY_TEAM_NAME_PAGEABLE
            .replace("{teamName}", teamName)
            .replace("{limit}", String.valueOf(pageable.getItemsCount()))
            .replace("{offset}", String.valueOf(pageable.getOffset()));
        return jdbcTemplate.query(query, gameWithSportAndTeamsExtractor);
    }

    @Override
    public void deleteBySportId(int sportId) {
        jdbcTemplate.update("DELETE FROM games where sport_id=?", sportId);
    }

    @Override
    public void deleteByTeamId(int teamId) {
        jdbcTemplate.update("DELETE FROM games where first_team_id=? OR second_team_id=?", teamId, teamId);
    }

    @Override
    public Integer create(Game game) {
        String query =
            "INSERT INTO games(date, sport_id, first_team_id, second_team_id, first_team_score, second_team_score) " +
            "VALUES(?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(
            query,
            game.getDate(),
            game.getSportId(),
            game.getFirstTeamId(),
            game.getSecondTeamId(),
            game.getFirstTeamScore(),
            game.getSecondTeamScore()
        );
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(query, new String[]{"id"});
            ps.setDate(1, Date.valueOf(game.getDate()));
            ps.setInt(2, game.getSportId());
            ps.setInt(3, game.getFirstTeamId());
            ps.setInt(4, game.getSecondTeamId());
            ps.setInt(5, game.getFirstTeamScore());
            ps.setInt(6, game.getSecondTeamScore());

            return ps;
        }, keyHolder);
        return keyHolder.getKey() == null ? null : keyHolder.getKey().intValue();
    }

    @Override
    public Game read(Integer key) {
        return jdbcTemplate.queryForObject("SELECT * FROM games WHERE id=?", BeanPropertyRowMapper.newInstance(Game.class), key);
    }

    @Override
    public boolean update(Game game) {
        String query =
            "UPDATE games SET " +
                "date=?," +
                "sport_id=?, " +
                "first_team_id=?, " +
                "second_team_id=?, " +
                "first_team_score=?, " +
                "second_team_score=? " +
            "WHERE id=?";
        return jdbcTemplate.update(
            query,
            game.getDate(),
            game.getSportId(),
            game.getFirstTeamId(),
            game.getSecondTeamId(),
            game.getFirstTeamScore(),
            game.getSecondTeamScore(),
            game.getId()
        ) > 0;
    }

    @Override
    public void delete(Integer key) {
        jdbcTemplate.update("DELETE FROM games where id=?", key);
    }

    @Override
    public List<Game> readAll() {
        return jdbcTemplate.query("SELECT * FROM games", BeanPropertyRowMapper.newInstance(Game.class));
    }
}
