package com.enigma.reader;

import com.enigma.dao.BoatingDockDao;
import com.enigma.dao.BoatingDockDaoMapImpl;
import com.enigma.runner.BoatingDockCommandRunnerImpl;
import com.enigma.runner.CommandRunner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BoatingDockInputReaderImpl implements InputReader {
    public static final String EXIT = "exit";
    public static final String NOTE = "Input command below:";
    @Override
    public void readCommand() throws IOException {
        BoatingDockDao boatingDockDao = new BoatingDockDaoMapImpl();
        CommandRunner commandRunner = new BoatingDockCommandRunnerImpl(boatingDockDao);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputs;
        System.out.println(NOTE);
        while (!(inputs=br.readLine()).equals(EXIT)){
            commandRunner.runCommands(inputs);
        }
        br.close();
    }
}
