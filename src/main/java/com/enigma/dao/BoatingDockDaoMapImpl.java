package com.enigma.dao;

import com.enigma.constant.MessageConstant;
import com.enigma.models.Boat;

import java.util.HashMap;
import java.util.Map;

public class BoatingDockDaoMapImpl implements BoatingDockDao {
    private Map<Integer, Boat> piers = new HashMap<>();
    private Integer capacity;

    public BoatingDockDaoMapImpl(Map<Integer, Boat> piers, Integer capacity) {
        this.piers = piers;
        this.capacity = capacity;
    }

    public BoatingDockDaoMapImpl(Integer capacity) {
        this.capacity = capacity;
    }

    public BoatingDockDaoMapImpl() {
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
    public String docking(Boat boat){
        for (Map.Entry<Integer, Boat> pier:piers.entrySet()){
            if (pier.getValue()==null){
                pier.setValue(boat);
                return String.format(MessageConstant.DOCK_SUCCESS, pier.getKey());
            }
        }
        return MessageConstant.DOCK_FAIL;
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
