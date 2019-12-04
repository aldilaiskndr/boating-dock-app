package com.enigma.dao;

import com.enigma.constant.MessageConstant;
import com.enigma.models.Boat;
import org.junit.Test;

import static org.junit.Assert.*;

public class BoatingDockDaoMapImplTest {

    @Test
    public void getCapacity_should_return_given_capacity() {
        Integer expectedCapacity = 6;
        BoatingDockDaoMapImpl boatingDock = new BoatingDockDaoMapImpl(6);
        assertEquals(expectedCapacity, boatingDock.getCapacity());
    }

    @Test
    public void setCapacity_should_change_capacity_value() {
        Integer givenCapacity = 6;
        BoatingDockDaoMapImpl boatingDockDaoMap = new BoatingDockDaoMapImpl();
        boatingDockDaoMap.setCapacity(givenCapacity);
        assertEquals(givenCapacity, boatingDockDaoMap.getCapacity());

    }

    @Test
    public void createBoatingDock_should_return_message_created_boating_dock_when_success() {
        Integer givenCapacity = 6;
        BoatingDockDao boatingDockDao = new BoatingDockDaoMapImpl();
        String expectedResult = String.format(MessageConstant.CREATED_BOATING_DOCK, givenCapacity);
        assertEquals(expectedResult, boatingDockDao.createBoatingDock(givenCapacity));
    }
    @Test
    public void createBoatingDock_should_return_message_created_boating_dock_fail_when_givenCapacity_0() {
        Integer givenCapacity = 0;
        BoatingDockDao boatingDockDao = new BoatingDockDaoMapImpl();
        assertEquals(MessageConstant.CREATED_BOATING_DOCK_FAIL, boatingDockDao.createBoatingDock(givenCapacity));
    }
    @Test
    public void createBoatingDock_should_return_message_created_boating_dock_fail_when_givenCapacity_lessThan0() {
        Integer givenCapacity = -4;
        BoatingDockDao boatingDockDao = new BoatingDockDaoMapImpl();
        assertEquals(MessageConstant.CREATED_BOATING_DOCK_FAIL, boatingDockDao.createBoatingDock(givenCapacity));
    }

    @Test
    public void docking_should_return_allocated_to_pier_number_1_when_1_boat_entry_to_pier_with_given_capacity_2() {
        Integer givenCapacity = 2;
        Boat boat = new Boat("KA-01-HH-1234", "White");
        BoatingDockDao boatingDockDao = new BoatingDockDaoMapImpl();
        boatingDockDao.createBoatingDock(givenCapacity);
        Integer expectedPierNumber = 1;
        String expectedResult = String.format(MessageConstant.DOCK_SUCCESS, expectedPierNumber);
        assertEquals(expectedResult, boatingDockDao.docking(boat));
    }
    @Test
    public void docking_should_return_allocated_to_pier_number_2_when_second_boat_entry_to_pier_with_given_capacity_2() {
        Integer givenCapacity = 2;
        Boat boat1 = new Boat("KA-01-HH-1234", "White");
        Boat boat2 = new Boat("KA-01-HH-9999", "White");
        BoatingDockDao boatingDockDao = new BoatingDockDaoMapImpl();
        boatingDockDao.createBoatingDock(givenCapacity);
        boatingDockDao.docking(boat1);
        Integer expectedPierNumber = 2;
        String expectedResult = String.format(MessageConstant.DOCK_SUCCESS, expectedPierNumber);
        assertEquals(expectedResult, boatingDockDao.docking(boat2));
    }
    @Test
    public void docking_should_return_message_dock_fail_when_second_boat_entry_to_pier_with_given_capacity_1() {
        Integer givenCapacity = 1;
        Boat boat1 = new Boat("KA-01-HH-1234", "White");
        Boat boat2 = new Boat("KA-01-HH-9999", "White");
        BoatingDockDao boatingDockDao = new BoatingDockDaoMapImpl();
        boatingDockDao.createBoatingDock(givenCapacity);
        boatingDockDao.docking(boat1);
        assertEquals(MessageConstant.DOCK_FAIL, boatingDockDao.docking(boat2));
    }

    @Test
    public void leave() {
    }

    @Test
    public void getStatus() {
    }

    @Test
    public void getBoatsByColour() {
    }

    @Test
    public void getSlotNumberByBoatColour() {
    }

    @Test
    public void getSlotNumberByBoat() {
    }
}