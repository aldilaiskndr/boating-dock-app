package com.enigma.models;

import org.junit.Test;

import static org.junit.Assert.*;

public class BoatTest {

    @Test
    public void getRegNumber_should_return_string_regNumber() {
        Boat boat = new Boat("KA-01-HH-1234", "White");
        String expectedReturn = "KA-01-HH-1234";
        assertEquals(expectedReturn, boat.getRegNumber());
    }

    @Test
    public void setRegNumber_should_change_regNumber_value() {
        Boat boat = new Boat("KA-01-HH-1234", "White");
        String newRegNumber = "KA-01-HH-1234";
        boat.setRegNumber(newRegNumber);
        assertEquals(newRegNumber, boat.getRegNumber());
    }

    @Test
    public void getColour_should_return_string_valueOf_colour() {
        Boat boat = new Boat("KA-01-HH-1234", "White");
        String expectedColour = "White";
        assertEquals(expectedColour, boat.getColour());
    }

    @Test
    public void setColour_should_change_colour_value() {
        Boat boat = new Boat("KA-01-HH-1234", "White");
        String newColour = "Green";
        boat.setColour(newColour);
        assertEquals(newColour, boat.getColour());
    }

    @Test
    public void testEquals_should_return_true_when_compare_a_boat() {
        Boat boat = new Boat("KA-01-HH-1234", "White");
        assertTrue(boat.equals(boat));
    }
}