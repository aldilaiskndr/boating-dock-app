package com.enigma.runner;

import com.enigma.constant.CommandConstant;
import com.enigma.constant.MessageConstant;
import com.enigma.dao.BoatingDockDao;
import com.enigma.models.Boat;
import com.enigma.runner.CommandRunner;

import java.util.List;

public class BoatingDockCommandRunnerImpl implements CommandRunner {
    private BoatingDockDao boatingDockDao;

    public BoatingDockCommandRunnerImpl(BoatingDockDao boatingDockDao) {
        this.boatingDockDao = boatingDockDao;
    }

    @Override
    public void runCommandList(List<String> rawCommands) {
        for (String rawCommand:rawCommands) {
            System.out.println(this.commandProcessor(rawCommand));
        }
    }

    @Override
    public void runCommands(String command) {
        System.out.println(this.commandProcessor(command));
    }

    @Override
    public String commandProcessor(String rawCommand) {
        String[] command = rawCommand.split(" ");
        switch (command[0]){
            case CommandConstant.CREATE_BOATING_DOCK:
                Integer capacity = Integer.parseInt(command[1]);
                return boatingDockDao.createBoatingDock(capacity);
            case CommandConstant.DOCK:
                Boat boat = new Boat(command[1], command[2]);
                return boatingDockDao.docking(boat);
            case CommandConstant.LEAVE:
                Integer pierNumber = Integer.parseInt(command[1]);
                return boatingDockDao.leave(pierNumber);
            case CommandConstant.STATUS:
               return boatingDockDao.getStatus();
            case CommandConstant.REG_NUMBERS_FOR_BOATS_WITH_COLOUR:
                return boatingDockDao.getBoatsByColour(command[1]);
            case CommandConstant.SLOT_NUMBERS_FOR_BOATS_WITH_COLOUR:
                return boatingDockDao.getSlotNumberByBoatColour(command[1]);
            case CommandConstant.SLOT_NUMBER_FOR_REG_NUMBER:
                return boatingDockDao.getSlotNumberByBoatRegNumber(command[1]);
            default:
                return MessageConstant.COMMAND_NOT_FOUND;
        }
    }
}
