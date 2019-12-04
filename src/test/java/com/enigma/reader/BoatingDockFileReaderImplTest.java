package com.enigma.reader;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class BoatingDockFileReaderImplTest {

    @Test
    public void readCommands_should_return_list_of_string_with_size_15_when_a_file_input() throws FileNotFoundException {
        Integer expectedSize = 15;
        String pathFileForTesting = "E:\\exam\\boating-dock-app\\src\\main\\resources\\file_inputs_unit_test.txt";
        FileReader fileReader = new BoatingDockFileReaderImpl();
        List<String> actualResult = fileReader.readCommands(pathFileForTesting);
        assertSame(expectedSize, actualResult.size());
    }
    @Test
    public void readCommands_should_return_list_of_string_with_exact_value_from_file_input_line_by_line() throws FileNotFoundException {
        List<String> expectedResult = new ArrayList<>();
        expectedResult.add("create_boating_dock 6");
        expectedResult.add("dock KA-01-HH-1234 White");
        expectedResult.add("dock KA-01-HH-9999 White");
        expectedResult.add("dock KA-01-BB-0001 Black");
        expectedResult.add("dock KA-01-HH-7777 Red");
        expectedResult.add("dock KA-01-HH-2701 Blue");
        expectedResult.add("dock KA-01-HH-3141 Black");
        expectedResult.add("leave 4");
        expectedResult.add("status");
        expectedResult.add("dock KA-01-P-333 White");
        expectedResult.add("dock DL-12-AA-9999 White");
        expectedResult.add("registration_numbers_for_boats_with_colour White");
        expectedResult.add("slot_numbers_for_boats_with_colour White");
        expectedResult.add("slot_number_for_registration_number KA-01-HH-3141");
        expectedResult.add("slot_number_for_registration_number MH-04-AY-1111");
        String pathFileForTesting = "E:\\exam\\boating-dock-app\\src\\main\\resources\\file_inputs_unit_test.txt";
        FileReader fileReader = new BoatingDockFileReaderImpl();
        List<String> actualResult = fileReader.readCommands(pathFileForTesting);
        assertEquals(expectedResult, actualResult);
    }
}