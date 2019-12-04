package com.enigma.runner;

import java.util.List;

public interface CommandRunner {
    void runCommandList(List<String> rawCommands);
    void runCommands(String command);
    String commandProcessor(String commandLine);
}
