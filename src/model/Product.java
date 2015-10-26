package model;

/**
 * Created by DuongTQ on 8/5/2014.
 */
public class Product {
    private String name;
    private double price;

    public Product() {
        this("Default", 0.0);
    }

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
