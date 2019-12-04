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
    public static final String EXIT_NOTE = "type 'exit' for close app";
    @Override
    public void readCommand(CommandRunner commandRunner) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputs;
        System.out.println(EXIT_NOTE);
        System.out.println(NOTE);
        while (!(inputs=br.readLine()).equals(EXIT)){
            commandRunner.runCommands(inputs);
        }
        br.close();
    }
}
