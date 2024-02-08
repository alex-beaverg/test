package com.solvd.web_testing.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;

import java.util.Objects;

public class ProductCard {
    private String title;
    private String description;
    private double price;

    public ProductCard() {
    }

    public ProductCard(String title, String description, double price) {
        this.title = title;
        this.description = description;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, price);
    }
}
