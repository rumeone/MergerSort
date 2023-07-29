package com.company.mergesort;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        if(args.length == 0) {
            System.out.println("Filenames not specified");
        }

        String sortMode = "-a";
        int start = 0;

        if(args[0].equals("-a") || args[0].equals("-d")) {
            sortMode = args[0];
            start = 1;
        }

        String dataType = args[start];
        String outputFile = args[start + 1];
        List<String> inputFileNames = Arrays.asList(args).subList(start + 2, args.length);

        if(dataType.equals("-i")) {

            MyFileWriter<Integer> myFileWriter = new MyFileWriter<>(outputFile);
            List<Integer> result = DataProcessor.fromIntegerFiles(inputFileNames);

            if(sortMode.equals("-d")) {
                Collections.reverse(result);
                myFileWriter.writeData(result);
            }
            else {
                myFileWriter.writeData(result);
            }
        }

        else if(dataType.equals("-s")) {
            MyFileWriter<String> myFileWriter = new MyFileWriter<>(outputFile);
            List<String> result = DataProcessor.fromStringFiles(inputFileNames);

            if(sortMode.equals("-d")) {
                Collections.reverse(result);
                myFileWriter.writeData(result);
            }
            else {
                myFileWriter.writeData(result);
            }
        }

    }
}