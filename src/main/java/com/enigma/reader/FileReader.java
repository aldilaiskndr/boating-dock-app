package com.enigma.reader;

import java.io.FileNotFoundException;
import java.util.List;

public interface FileReader {
    List<String> readCommands(String path) throws FileNotFoundException;
}
