package com.enigma.runner;

import com.enigma.constant.MessageConstant;
import com.enigma.dao.BoatingDockDao;
import com.enigma.dao.BoatingDockDaoMapImpl;
import com.enigma.models.Boat;
import org.junit.jupiter.api.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BoatingDockCommandRunnerImplTest {

    @Test
    void runCommandList_should_call_commandProcessor_once() {
        String command = "create_boating_dock 6";
        List<String> rawCommands = new ArrayList<>();
        rawCommands.add(command);
        BoatingDockDao boatingDockDao = new BoatingDockDaoMapImpl();
        CommandRunner commandRunner = spy(new BoatingDockCommandRunnerImpl(boatingDockDao));
        commandRunner.runCommandList(rawCommands);
        verify(commandRunner, times(1)).commandProcessor(command);
    }

    @Test
    void runCommands_should_call_commandProcessor_once() {
        String command = "create_boating_dock 6";
        BoatingDockDao boatingDockDao = new BoatingDockDaoMapImpl();
        CommandRunner commandRunner = spy(new BoatingDockCommandRunnerImpl(boatingDockDao));
        commandRunner.runCommands(command);
        verify(commandRunner, times(1)).commandProcessor(Matchers.anyString());
    }

    @Test
    void commandProcessor_should_call_BoatingDockDao_createBoatingDao_once_when_command_create_boating_dock_input() {
        String command = "create_boating_dock 6";
        BoatingDockDao boatingDockDao = mock(BoatingDockDaoMapImpl.class);
        CommandRunner commandRunner = new BoatingDockCommandRunnerImpl(boatingDockDao);
        commandRunner.commandProcessor(command);
        verify(boatingDockDao, times(1)).createBoatingDock(Matchers.anyInt());
    }
    @Test
    void commandProcessor_should_call_BoatingDockDao_dock_once_when_command_dock_input() {
        String command = "dock KH-01-HH-1234 White";
        BoatingDockDao boatingDockDao = mock(BoatingDockDaoMapImpl.class);
        CommandRunner commandRunner = new BoatingDockCommandRunnerImpl(boatingDockDao);
        commandRunner.commandProcessor(command);
        verify(boatingDockDao, times(1)).docking(Matchers.any(Boat.class));
    }
    @Test
    void commandProcessor_should_call_BoatingDockDao_leave_once_when_command_leave_input() {
        String command = "leave 1";
        BoatingDockDao boatingDockDao = mock(BoatingDockDaoMapImpl.class);
        CommandRunner commandRunner = new BoatingDockCommandRunnerImpl(boatingDockDao);
        commandRunner.commandProcessor(command);
        verify(boatingDockDao, times(1)).leave(Matchers.anyInt());
    }
    @Test
    void commandProcessor_should_call_BoatingDockDao_getStatus_once_when_command_status_input() {
        String command = "status";
        BoatingDockDao boatingDockDao = mock(BoatingDockDaoMapImpl.class);
        CommandRunner commandRunner = new BoatingDockCommandRunnerImpl(boatingDockDao);
        commandRunner.commandProcessor(command);
        verify(boatingDockDao, times(1)).getStatus();
    }
    @Test
    void commandProcessor_should_call_BoatingDockDao_getBoatsByColour_once_when_command_registration_numbers_for_boats_with_colour_input() {
        String command = "registration_numbers_for_boats_with_colour White";
        BoatingDockDao boatingDockDao = mock(BoatingDockDaoMapImpl.class);
        CommandRunner commandRunner = new BoatingDockCommandRunnerImpl(boatingDockDao);
        commandRunner.commandProcessor(command);
        verify(boatingDockDao, times(1)).getBoatsByColour(Matchers.anyString());
    }
    @Test
    void commandProcessor_should_call_BoatingDockDao_getSlotNumberByBoatColour_once_when_command_slot_numbers_for_boats_with_colour_input() {
        String command = "slot_numbers_for_boats_with_colour White";
        BoatingDockDao boatingDockDao = mock(BoatingDockDaoMapImpl.class);
        CommandRunner commandRunner = new BoatingDockCommandRunnerImpl(boatingDockDao);
        commandRunner.commandProcessor(command);
        verify(boatingDockDao, times(1)).getSlotNumberByBoatColour(Matchers.anyString());
    }
    @Test
    void commandProcessor_should_call_BoatingDockDao_getSlotNumberByBoatRegNumber_once_when_command_slot_number_for_registration_number_input() {
        String command = "slot_number_for_registration_number KA-01-HH-3141";
        BoatingDockDao boatingDockDao = mock(BoatingDockDaoMapImpl.class);
        CommandRunner commandRunner = new BoatingDockCommandRunnerImpl(boatingDockDao);
        commandRunner.commandProcessor(command);
        verify(boatingDockDao, times(1)).getSlotNumberByBoatRegNumber(Matchers.anyString());
    }
    @Test
    void commandProcessor_should_return_message_not_suitable_commands_when_there_is_no_suitable_command_with_inputs(){
        String command = "dummy command";
        BoatingDockDao boatingDockDao = new BoatingDockDaoMapImpl();
        CommandRunner commandRunner = new BoatingDockCommandRunnerImpl(boatingDockDao);
        assertEquals(MessageConstant.COMMAND_NOT_FOUND, commandRunner.commandProcessor(command));
    }
}