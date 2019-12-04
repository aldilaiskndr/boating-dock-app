package com.enigma;

import com.enigma.dao.BoatingDockDao;
import com.enigma.dao.BoatingDockDaoMapImpl;
import com.enigma.reader.BoatingDockInputReaderImpl;
import com.enigma.reader.InputReader;
import com.enigma.runner.BoatingDockCommandRunnerImpl;
import com.enigma.reader.BoatingDockFileReaderImpl;
import com.enigma.runner.CommandRunner;
import com.enigma.reader.FileReader;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static final String  USING_INPUT = "input";
    public static void main(String[] args) throws FileNotFoundException {
        BoatingDockDao boatingDockDao = new BoatingDockDaoMapImpl();
        CommandRunner commandRunner = new BoatingDockCommandRunnerImpl(boatingDockDao);
        if(args[0].equals(USING_INPUT)){
            try {
                InputReader inputReader = new BoatingDockInputReaderImpl();
                inputReader.readCommand(commandRunner);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            String file = args[0];
            FileReader fileReader = new BoatingDockFileReaderImpl();
            commandRunner.runCommandList(fileReader.readCommands(file));
        }
    }
}
