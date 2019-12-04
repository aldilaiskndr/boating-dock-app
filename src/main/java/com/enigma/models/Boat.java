package com.enigma.models;

import java.util.Objects;

public class Boat {
    private String regNumber;
    private String colour;

    public Boat(String regNumber, String colour) {
        this.regNumber = regNumber;
        this.colour = colour;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Boat boat = (Boat) o;
        return Objects.equals(regNumber, boat.regNumber) &&
                Objects.equals(colour, boat.colour);
    }

}
