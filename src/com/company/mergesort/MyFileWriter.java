package com.company.mergesort;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class MyFileWriter<T> {
    private final String fileName;

    public MyFileWriter(String fileName) {
        this.fileName = fileName;
    }

    public void writeData(List<T> data) {
        if (data == null) {
            System.out.println("Data is null");
            return;
        }
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName))) {
            for (T item : data) {
                bufferedWriter.write(item.toString());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error writing file: " + e.getMessage());
        }
    }

}
