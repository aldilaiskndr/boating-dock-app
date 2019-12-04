package com.enigma.dao;

import com.enigma.constant.MessageConstant;
import com.enigma.models.Boat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    public String leave(Integer pierNumber){
        for (Map.Entry<Integer, Boat> pier:piers.entrySet()){
            if (pier.getKey().equals(pierNumber)&&pier.getValue()!=null){
                pier.setValue(null);
                return String.format(MessageConstant.LEAVE, pier.getKey());
            }else if(pier.getValue()==null){
                return String.format(MessageConstant.LEAVE_FAIL, pier.getKey());
            }
        }
        return String.format(MessageConstant.PIER_NUMBER_NOT_FOUND, pierNumber);
    }
    @Override
    public String getStatus(){
        StringBuilder status = new StringBuilder();
        String header = String.format("%-10s%-20s%-10s", MessageConstant.STATUS_HEAD_NUMBER, MessageConstant.STATUS_HEAD_REG_NUMBER, MessageConstant.STATUS_HEAD_COLOUR);
        status.append(header);
        for (Map.Entry<Integer, Boat> pier:piers.entrySet()){
            if (pier.getValue()!=null){
                status.append(String.format("\n%-10d%-20s%-10s", pier.getKey(), pier.getValue().getRegNumber(), pier.getValue().getColour()));
            }
        }
        return status.toString();
    }
    @Override
    public String getBoatsByColour(String keywordColour){
        Integer empty = 0;
        List<String> regNumbers = new ArrayList<>();
        for (Map.Entry<Integer, Boat> pier:piers.entrySet()){
            if(pier.getValue().getColour().equals(keywordColour)){
                regNumbers.add(pier.getValue().getRegNumber());
            }
        }
        if(regNumbers.size()!=empty){
            return regNumbers.toString();
        }
        return MessageConstant.NO_MATCHING_COLOUR;
    }
    @Override
    public String getSlotNumberByBoatColour(String keywordColour){
        Integer empty = 0;
        List<Integer> pierNumbers = new ArrayList<>();
        for (Map.Entry<Integer, Boat> pier:piers.entrySet()){
            if(pier.getValue().getColour().equals(keywordColour)){
                pierNumbers.add(pier.getKey());
            }
        }
        if(pierNumbers.size()!=empty){
            return pierNumbers.toString();
        }
        return MessageConstant.NO_MATCHING_COLOUR;
    }
    @Override
    public String getSlotNumberByBoat(){
        return null;
    }
}
