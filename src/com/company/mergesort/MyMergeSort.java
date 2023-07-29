package com.company.mergesort;

import java.util.ArrayList;
import java.util.List;

public class MyMergeSort<T extends Comparable<T>> {

    public void mergeSort(List<T> list) {
        if(list == null || list.size() <= 1) {
            return;
        }

        int middle = list.size() / 2;

        List<T> left = new ArrayList<>(list.subList(0, middle));
        List<T> right = new ArrayList<>(list.subList(middle, list.size()));

        mergeSort(left);
        mergeSort(right);

        merge(list, left, right);
    }

    private void merge(List<T> result, List<T> left, List<T> right) {
        int leftIndex = 0;
        int rightIndex = 0;
        int resultIndex = 0;

        while (leftIndex < left.size() && rightIndex < right.size()) {
            T leftElement = left.get(leftIndex);
            T rightElement = right.get(rightIndex);

            if (leftElement.compareTo(rightElement) <= 0) {
                result.set(resultIndex, leftElement);
                leftIndex++;
            } else {
                result.set(resultIndex, rightElement);
                rightIndex++;
            }
            resultIndex++;
        }

        while (leftIndex < left.size()) {
            result.set(resultIndex, left.get(leftIndex));
            leftIndex++;
            resultIndex++;
        }

        while (rightIndex < right.size()) {
            result.set(resultIndex, right.get(rightIndex));
            rightIndex++;
            resultIndex++;
        }
    }
}
