package com.techelevator.dao;

import com.techelevator.model.Park;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

public class JdbcParkDaoTests extends BaseDaoTests {

    private static final Park PARK_1 =
            new Park(1, "Park 1", LocalDate.parse("1800-01-02"), 100, true);
    private static final Park PARK_2 =
            new Park(2, "Park 2", LocalDate.parse("1900-12-31"), 200, false);
    private static final Park PARK_3 =
            new Park(3, "Park 3", LocalDate.parse("2000-06-15"), 300, false);

    private JdbcParkDao sut;
    private Park testPark;

    @Before
    public void setup() {
        sut = new JdbcParkDao(dataSource);
        testPark = new Park(0, "Dave Park", LocalDate.parse("2021-10-21"),
                123.4, true);
    }

    //@Test
    public void getPark_returns_correct_park_for_id() {
        // Arrange - Already done via Spring and @Setup method

        // Act
        Park park = sut.getPark(2);

        // Assert - ensure 'park' equals 'PARK_2'
        assertParksMatch(PARK_2, park);
    }

    //@Test
    public void getPark_returns_null_when_id_not_found() {
        // Act
        Park park = sut.getPark(-1);

        // Assert
        Assert.assertNull(park);
    }

    //@Test
    public void getParksByState_returns_all_parks_for_state() {
        // Act
        List<Park> parks = sut.getParksByState("AA");

        // Assert
        Assert.assertEquals(2, parks.size());
        assertParksMatch(PARK_1, parks.get(0));
        assertParksMatch(PARK_3, parks.get(1));
    }

    //@Test
    public void getParksByState_returns_empty_list_for_abbreviation_not_in_db() {
        // Act
        List<Park> parks = sut.getParksByState("ZZ");

        // Assert
        Assert.assertEquals(0, parks.size());
    }

    @Test
    public void createPark_returns_park_with_id_and_expected_values() {
        // Act
        Park actual = sut.createPark(testPark);

        // Set testPark's ID to actual's as a future test may be added someday that creates
        // a park before this test case runs
        testPark.setParkId(actual.getParkId());

        // Assert
        assertParksMatch(testPark, actual);
    }

    @Test
    public void created_park_has_expected_values_when_retrieved() {
        // Arrange - Insert a park
        testPark = sut.createPark(testPark);

        // Act - Retrieve the park that was just created
        Park actual = sut.getPark(testPark.getParkId());

        // Assert that the re-retrieved park equals the park that was created
        assertParksMatch(testPark, actual);
    }

    //@Test
    public void updated_park_has_expected_values_when_retrieved() {
        // Arrange
        Park updatedPark = new Park(1, "Park One", LocalDate.parse("1900-01-02"),
                200, false);

        // Act
        sut.updatePark(updatedPark);

        // Assert
        Park actual = sut.getPark(1);
        assertParksMatch(updatedPark, actual);
    }

    //@Test
    public void deleted_park_cant_be_retrieved() {
        // Arrange - Delete an existing park
        sut.deletePark(1);

        // Act - Retrieve park with ID 1
        Park actual = sut.getPark(1);

        // Assert
        Assert.assertNull(actual);
    }

    //@Test
    public void park_added_to_state_is_in_list_of_parks_by_state() {
        // Arrange
        sut.addParkToState(2, "AA");

        // Act
        List<Park> parks = sut.getParksByState("AA");

        // Assert
        boolean foundId = false;
        for (Park park : parks) {
            if (park.getParkId() == 2) {
                foundId = true;
            }
        }
        Assert.assertTrue("getParksByState did not return park ID 2", foundId);
    }

    //@Test
    public void park_removed_from_state_is_not_in_list_of_parks_by_state() {
        // Arrange
        sut.removeParkFromState(1,"AA");

        // Act
        List<Park> parks = sut.getParksByState("AA");

        // Assert
        // Ensure park deleted from state
        Assert.assertEquals(1, parks.size());

        boolean found = false;
        for (Park park : parks) {
            if (park.getParkId() == 1) {
                found = true;
                break;
            }
        }
        Assert.assertTrue("Get parks by state found park with ID 1", found == false);
    }

    private void assertParksMatch(Park expected, Park actual) {
        Assert.assertEquals(expected.getParkId(), actual.getParkId());
        Assert.assertEquals(expected.getParkName(), actual.getParkName());
        Assert.assertEquals(expected.getDateEstablished(), actual.getDateEstablished());
        Assert.assertEquals(expected.getArea(), actual.getArea(), 0.1);
        Assert.assertEquals(expected.getHasCamping(), actual.getHasCamping());
    }

}
