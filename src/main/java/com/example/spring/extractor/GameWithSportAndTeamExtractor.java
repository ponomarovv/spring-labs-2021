package com.example.spring.extractor;

import com.example.spring.entity.Game;
import com.example.spring.entity.Sport;
import com.example.spring.entity.Team;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class GameWithSportAndTeamExtractor implements ResultSetExtractor<List<Game>> {
    @Override
    public List<Game> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
        List<Game> games = new ArrayList<>();
        while (resultSet.next()) {
            Game game = new Game();

            game.setId(resultSet.getInt("id"));
            game.setDate(resultSet.getDate("date").toLocalDate());
            game.setSportId(resultSet.getInt("sport_id"));
            game.setFirstTeamId(resultSet.getInt("first_team_id"));
            game.setSecondTeamId(resultSet.getInt("second_team_id"));
            game.setFirstTeamScore(resultSet.getInt("first_team_score"));
            game.setSecondTeamScore(resultSet.getInt("second_team_score"));

            game.setSport(mapSport(resultSet));
            game.setFirstTeam(mapTeam(resultSet, "first_team"));
            game.setSecondTeam(mapTeam(resultSet, "second_team"));

            games.add(game);
        }
        return games;
    }

    private Sport mapSport(ResultSet resultSet) throws SQLException {
        Sport sport = new Sport();

        sport.setId(resultSet.getInt("sport_id"));
        sport.setName(resultSet.getString("sport_name"));

        return sport;
    }

    private Team mapTeam(ResultSet resultSet, String prefix) throws SQLException {
        Team team = new Team();

        team.setId(resultSet.getInt(prefix + "_id"));
        team.setName(resultSet.getString(prefix + "_name"));

        return team;
    }
}
