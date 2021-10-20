package com.techelevator.dao;

import com.techelevator.model.Park;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class JdbcParkDao implements ParkDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcParkDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Park getPark(long parkId) {
        String sql = "SELECT park.park_id, park_name, date_established, area, has_camping" +
                " FROM park" +
                " WHERE park_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        if (results.next()) {
            return mapRowToPark(results);
        }
        return null;
    }

    @Override
    public List<Park> getParksByState(String stateAbbreviation) {
        String sql = "SELECT park.park_id, park_name, date_established, area, has_camping" +
                " FROM park" +
                " JOIN park_state ON park.park_id = park_state.park_id" +
                " WHERE state_abbreviation = ?;";
        SqlRowSet parks = this.jdbcTemplate.queryForRowSet(sql, stateAbbreviation);

        List<Park> parkResults = new ArrayList<Park>();

        while (parks.next()) {
            Park park = mapRowToPark(parks);
            parkResults.add(park);
        }

        return parkResults;
    }

    @Override
    public Park createPark(Park park) {

        String sql = "INSERT INTO park(park_name, date_established, area, has_camping)" +
                " VALUES(?, ?, ?, ?) RETURNING park_id;";
        Long newParkId = jdbcTemplate.queryForObject(sql, Long.class,
                park.getParkName(), park.getDateEstablished(), park.getArea(), park.getHasCamping());

        //park.setParkId(newParkId);
        //return park;

        return getPark(newParkId);
    }

    @Override
    public void updatePark(Park park) {
        String sql = "UPDATE park SET park_name = ?, date_established = ?, area = ?, has_camping = ?" +
                " WHERE park_id = ?;";
        jdbcTemplate.update(sql, park.getParkName(), park.getDateEstablished(),
                park.getArea(), park.getHasCamping(), park.getParkId());
    }

    @Override
    public void deletePark(long parkId) {
        String sql = "DELETE FROM park WHERE park_id = ?";
        try {
            int numRowsAffected = jdbcTemplate.update(sql, parkId);

            if (numRowsAffected == 0) {
                System.err.println("deletePark called with invalid parkId " + parkId);
            }
        }
        catch (DataIntegrityViolationException e) {
            System.out.println("Error deleting park");
        }
    }

    @Override
    public void addParkToState(long parkId, String stateAbbr3eviation) {

    }

    @Override
    public void removeParkFromState(long parkId, String stateAbbreviation) {

    }

    private Park mapRowToPark(SqlRowSet rowSet) {
        Park park = new Park();

        park.setParkId(rowSet.getLong("park_id"));
        park.setParkName(rowSet.getString("park_name"));

        //park.setDateEstablished(rowSet.getDate("date_established").toLocalDate());
        // If value may be null have to use code like this
        Date dateEstablishedFromDb = rowSet.getDate("date_established");
        if (dateEstablishedFromDb != null) {
            park.setDateEstablished(dateEstablishedFromDb.toLocalDate());
        } else {
            park.setDateEstablished(null);
        }
        park.setArea(rowSet.getDouble("area"));
        park.setHasCamping(rowSet.getBoolean("has_camping"));

        // Required to fully qualify because java.sql.Date has been imported
        // java.util.Date now = new java.util.Date();

        return park;
    }
}
