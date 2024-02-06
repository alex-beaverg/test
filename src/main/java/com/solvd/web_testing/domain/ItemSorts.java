package com.solvd.web_testing.domain;

public enum ItemSorts {
    ASC("Name (A to Z)"),
    DESC("Name (Z to A)");

    private final String sortType;

    ItemSorts(String sortType) {
        this.sortType = sortType;
    }

    public String getSortType() {
        return sortType;
    }
}
