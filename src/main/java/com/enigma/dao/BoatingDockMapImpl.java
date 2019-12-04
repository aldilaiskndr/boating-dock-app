package com.enigma.dao;

import com.enigma.models.Boat;

import java.util.HashMap;
import java.util.Map;

public class BoatingDockMapImpl implements BoatingDock {
    private Map<Integer, Boat> piers = new HashMap<>();
    private Integer capacity;

    @Override
    public String createBoatingDock(Integer capacity){
        return null;
    }
    @Override
    public String dock(Boat boat){
        return null;
    }
    @Override
    public String leave(Boat boat, Integer pierNumber){
        return null;
    }
    @Override
    public String getStatus(){
        return null;
    }
    @Override
    public String getBoatsByColour(){
        return null;
    }
    @Override
    public String getSlotNumberByBoatColour(){
        return null;
    }
    @Override
    public String getSlotNumberByBoat(){
        return null;
    }
}
