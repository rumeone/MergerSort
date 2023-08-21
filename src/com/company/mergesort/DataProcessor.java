package com.company.mergesort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataProcessor<T> {

    public static List<Integer> fromIntegerFiles(List<String> fileNames) {
        List<Integer> allNumbers = new ArrayList<>();
        for (String fileName : fileNames) {
            MyFileReader myFileReader = new MyFileReader(fileName);
            List<Integer> numbersFromFile = myFileReader.readInteger();
            allNumbers.addAll(numbersFromFile);
        }

        MyMergeSort<Integer> myMergeSort = new MyMergeSort<>();
        myMergeSort.mergeSort(allNumbers);

        return allNumbers;
    }

    public static List<String> fromStringFiles(List<String> fileNames) {
        List<String> allString = new ArrayList<>();
        for (String fileName : fileNames) {
            MyFileReader myFileReader = new MyFileReader(fileName);
            List<String> stringsFromFile = myFileReader.readString();
            allString.addAll(stringsFromFile);
        }

        MyMergeSort<String> myMergeSort = new MyMergeSort<>();
        myMergeSort.mergeSort(allString);

        return allString;
    }

}
