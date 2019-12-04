package com.enigma.dao;

import com.enigma.constant.MessageConstant;
import com.enigma.models.Boat;

import java.util.HashMap;
import java.util.Map;

public class BoatingDockMapImpl implements BoatingDock {
    private Map<Integer, Boat> piers = new HashMap<>();
    private Integer capacity;

    public BoatingDockMapImpl(Map<Integer, Boat> piers, Integer capacity) {
        this.piers = piers;
        this.capacity = capacity;
    }

    public BoatingDockMapImpl(Integer capacity) {
        this.capacity = capacity;
    }

    public BoatingDockMapImpl() {
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    @Override
    public String createBoatingDock(Integer capacity){
        if(capacity>0){
            this.setCapacity(capacity);
            for (int i = 1; i <= this.capacity ; i++) {
                piers.put(i, null);
            }
            return String.format(MessageConstant.CREATED_BOATING_DOCK, this.capacity);
        }
        return MessageConstant.CREATED_BOATING_DOCK_FAIL;
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
