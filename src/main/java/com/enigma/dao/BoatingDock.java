package com.enigma.dao;

import com.enigma.models.Boat;

public interface BoatingDock {
    String createBoatingDock(Integer capacity);

    String dock(Boat boat);

    String leave(Boat boat, Integer pierNumber);

    String getStatus();

    String getBoatsByColour();

    String getSlotNumberByBoatColour();

    String getSlotNumberByBoat();
}
