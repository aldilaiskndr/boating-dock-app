package com.enigma.reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BoatingDockFileReaderImpl implements FileReader {
    @Override
    public List<String> readCommands(String path) {
        List<String> rawCommands = new ArrayList<>();
        try (java.io.FileReader reader = new java.io.FileReader(path);
             BufferedReader br = new BufferedReader(reader)) {
            String line;
            while ((line = br.readLine()) != null) {
                rawCommands.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rawCommands;
    }
}
