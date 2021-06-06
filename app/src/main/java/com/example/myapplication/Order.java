package com.example.myapplication;

public class Order {
    private String date, price, summary, status, address, name;
    Order(){

    }

    public Order(String date, String price, String summary, String status, String address, String name) {
        this.date = date;
        this.price = price;
        this.summary = summary;
        this.status = status;
        this.address = address;
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }
}
