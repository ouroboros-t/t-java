package com.techelevator.dao;

import com.techelevator.model.Park;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcParkDao implements ParkDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcParkDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Park getPark(long parkId) {
        String sql = "SELECT park.park_id, park_name, date_established, area, has_camping " +
                "FROM park WHERE park_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        if(results.next()){
         return mapRowToPark(results);
        }
        return null;
    }

    @Override
    public List<Park> getParksByState(String stateAbbreviation) {
        //return new ArrayList<Park>();
        String sql = "SELECT park.park_id, park_name, date_established, area, has_camping " +
                "FROM park" +
                " JOIN park_state ON park.park_id = park_state.park_id" +
                " WHERE park_state.state_abbreviation = ?;";
        SqlRowSet parks = this.jdbcTemplate.queryForRowSet(sql, stateAbbreviation);

        List<Park> parkResults = new ArrayList<Park>();
        while(parks.next()){
            Park park = mapRowToPark(parks);
            parkResults.add(park);
        }
        return parkResults;
    }

    @Override
    public Park createPark(Park park) {
        String sql = "INSERT INTO park (park_name, date_established, area, has_camping) " +
                "VALUES (?, ?, ?, ?) RETURNING park_id;";
        Long newId = jdbcTemplate.queryForObject(sql, Long.class, park.getParkName(),
                park.getDateEstablished(), park.getArea(), park.getHasCamping());

        park.setParkId(newId);
        return park;
    }

    @Override
    public void updatePark(Park park) {
        String sql = "UPDATE park " +
                "SET park_name = ?, date_established = ?, area = ?, has_camping = ?" +
                "WHERE park_id = ?;";

        jdbcTemplate.update(sql, park.getParkName(), park.getDateEstablished(),
                park.getArea(), park.getHasCamping(), park.getParkId());
    }

    @Override
    public void deletePark(long parkId) {
        String sql = "DELETE FROM park WHERE park_id = ?;";
        try{
            int numRowsAffected = jdbcTemplate.update(sql,parkId);

            if(numRowsAffected == 0){
                System.err.println("deletePark called in with invalid parkId: " + parkId);
            }

        } catch (DataIntegrityViolationException e){
            System.out.println("Error deleting park");
        }

    }

    @Override
    public void addParkToState(long parkId, String stateAbbreviation) {
        String sql = "INSERT INTO park_state WHERE park_id = ? AND state_abbreviation = ?;";
        jdbcTemplate.update(sql,parkId,stateAbbreviation);
    }

    @Override
    public void removeParkFromState(long parkId, String stateAbbreviation) {


    }

    private Park mapRowToPark(SqlRowSet rowSet) {
        //get all of the columns for the row.
        Park park = new Park();
        park.setParkId(rowSet.getLong("park_id"));
        park.setParkName(rowSet.getString("park_name"));
        park.setDateEstablished(rowSet.getDate("date_established").toLocalDate());
        park.setArea(rowSet.getDouble("area"));
        park.setHasCamping(rowSet.getBoolean("has_camping"));

        return park;
    }
}
