package com.enigma.dao;

import com.enigma.constant.MessageConstant;
import com.enigma.models.Boat;
import org.junit.Test;

import static org.junit.Assert.*;

public class BoatingDockMapImplTest {

    @Test
    public void getCapacity_should_return_given_capacity() {
        Integer expectedCapacity = 6;
        BoatingDockMapImpl boatingDock = new BoatingDockMapImpl(6);
        assertEquals(expectedCapacity, boatingDock.getCapacity());
    }

    @Test
    public void setCapacity_should_change_capacity_value() {
        Integer givenCapacity = 6;
        BoatingDockMapImpl boatingDockMap = new BoatingDockMapImpl();
        boatingDockMap.setCapacity(givenCapacity);
        assertEquals(givenCapacity, boatingDockMap.getCapacity());

    }

    @Test
    public void createBoatingDock_should_return_message_created_boating_dock_when_success() {
        Integer givenCapacity = 6;
        BoatingDock boatingDock = new BoatingDockMapImpl();
        String expectedResult = String.format(MessageConstant.CREATED_BOATING_DOCK, givenCapacity);
        assertEquals(expectedResult, boatingDock.createBoatingDock(givenCapacity));
    }
    @Test
    public void createBoatingDock_should_return_message_created_boating_dock_fail_when_givenCapacity_0() {
        Integer givenCapacity = 0;
        BoatingDock boatingDock = new BoatingDockMapImpl();
        assertEquals(MessageConstant.CREATED_BOATING_DOCK_FAIL, boatingDock.createBoatingDock(givenCapacity));
    }
    @Test
    public void createBoatingDock_should_return_message_created_boating_dock_fail_when_givenCapacity_lessThan0() {
        Integer givenCapacity = -4;
        BoatingDock boatingDock = new BoatingDockMapImpl();
        assertEquals(MessageConstant.CREATED_BOATING_DOCK_FAIL, boatingDock.createBoatingDock(givenCapacity));
    }

    @Test
    public void dock() {
        Boat boat = new Boat("KA-01-HH-1234", "White");

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