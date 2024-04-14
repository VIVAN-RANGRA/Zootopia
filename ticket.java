package org.example;
public class ticket {
    private int count ;
    private attraction a;
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
    public attraction getA() {
        return a;
    }

    public void setA(attraction a) {
        this.a = a;
    }

    public ticket(int count, attraction a) {
        this.count = count;
        this.a = a;
    }
}