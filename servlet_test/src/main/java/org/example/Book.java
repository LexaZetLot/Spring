package org.example;

public class Book {
    private int id;
    private String item;
    private float price;

    Book(int id, String item, float price){
        this.id = id;
        this.item = item;
        this.price = price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getItem() {
        return item;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return ("Id: " + id + " Item: " + item + " Price: " + price);
    }
}
