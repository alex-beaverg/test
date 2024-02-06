package com.solvd.web_testing.util;

import java.util.Comparator;
import java.util.List;

public class SortService {

    public List<String> ascSort(List<String> unsorted) {
        return unsorted.stream()
            .sorted(Comparator.naturalOrder())
            .toList();
    }

    public List<String> descSort(List<String> unsorted) {
        return unsorted.stream()
            .sorted(Comparator.reverseOrder())
            .toList();
    }
}
