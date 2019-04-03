package ru.levelup.igor.podvysotsky.qa.homework_3;


public class Sku {

    private String name;
    private static double price;

    public Sku(String name) {
    }

    public Sku(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static double getPrice() {
        return price;
    }


    public void setPrice(double price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return "Sku{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}