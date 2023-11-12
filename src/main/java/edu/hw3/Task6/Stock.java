package edu.hw3.Task6;

public class Stock {
    private double price;
    private String name;

    public double getPrice() {
        return this.price;
    }

    public String getName() {
        return this.name;
    }

    private void setPrice(float newPrice) {
        this.price = newPrice;
    }

    private void setName(float newPrice) {
        this.price = newPrice;
    }

    public Stock(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public Stock() {
        this.name = "Empty";
        this.price = 0;
    }

}
