package com.company.mergesort;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MyFileReader {
    private final String fileName;

    public MyFileReader(String filePath) {
        this.fileName = filePath;
    }

    public List<Integer> readInteger() {
        List<Integer> integers = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    int number = Integer.parseInt(line.trim());
                    integers.add(number);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid integer format: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        return integers;
    }

    public List<String> readString() {
        List<String> strings = new ArrayList<>();

        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while((line = reader.readLine()) != null) {
                try {
                    Integer.parseInt(line.trim());
                    System.out.println("Numeric strings will be skipped");
                } catch (NumberFormatException e) {
                    if (line.trim().contains(" ")) {
                        System.out.println("Words with spaces will be skipped!");
                    }
                    strings.add(line.trim());
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return strings;
    }

}
