package com.enigma.dao;

import com.enigma.models.Boat;

public interface BoatingDockDao {
    String createBoatingDock(Integer capacity);

    String docking(Boat boat);

    String leave(Integer pierNumber);

    String getStatus();

    String getBoatsByColour(String keywordColour);

    String getSlotNumberByBoatColour(String keywordColour);

    String getSlotNumberByBoat();
}
