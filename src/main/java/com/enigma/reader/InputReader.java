package com.enigma.reader;

import com.enigma.runner.CommandRunner;

import java.io.IOException;

public interface InputReader {
    void readCommand(CommandRunner commandRunner) throws IOException;
}
