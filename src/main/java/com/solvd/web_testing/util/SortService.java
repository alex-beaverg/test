package com.solvd.web_testing.util;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortService {

    public List<String> ascSort(List<String> unsorted) {
        return unsorted.stream()
            .sorted(Comparator.naturalOrder())
            .collect(Collectors.toList());
    }

    public List<String> descSort(List<String> unsorted) {
        return unsorted.stream()
            .sorted(Comparator.reverseOrder())
            .collect(Collectors.toList());
    }
}
