package org.example;
public class attraction {
    private String name;
    private String description;
    public attraction(String name) {
        this.name = name;
    }
    public attraction(){}
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    private int price = 20;
    private String state ="open";
    private int count =0;
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
}
