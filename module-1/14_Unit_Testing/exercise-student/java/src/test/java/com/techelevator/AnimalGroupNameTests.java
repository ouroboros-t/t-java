package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class AnimalGroupNameTests {
    @Test
    public void elephant_returns_herd() {
        //Arrange
        AnimalGroupName animalGroupName = new AnimalGroupName();
        //Act
        String actual = animalGroupName.getHerd("elephant");
        //Assert
        Assert.assertEquals("Animal name does not match herd", "Herd", actual);

    }

    @Test
    public void giraffe_multi_case_returns_herd() {
        //Arrange
        AnimalGroupName animalGroupName = new AnimalGroupName();
        //Act
        String actual = animalGroupName.getHerd("GIRaFfe");
        //Assert
        Assert.assertEquals("Tower", actual);
    }

    @Test
    public void null_string_returns_unknown() {
        //Arrange
        AnimalGroupName animalGroupName = new AnimalGroupName();
        //Act
        String actual = animalGroupName.getHerd(null);
        //Assert
        Assert.assertEquals("unknown", actual);
    }

    @Test
    public void blank_string_returns_unknown() {
        //Arrange
        AnimalGroupName animalGroupName = new AnimalGroupName();
        //Act
        String actual = animalGroupName.getHerd("");
        //Assert
        Assert.assertEquals("unknown", actual);
    }

    @Test
    public void animal_not_in_map_returns_unknown() {
        //Arrange
        AnimalGroupName animalGroupName = new AnimalGroupName();
        //Act
        String actual = animalGroupName.getHerd("penguin");
        //Assert
        Assert.assertEquals("unknown", actual);
    }

}
