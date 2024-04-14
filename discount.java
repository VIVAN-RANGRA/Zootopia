package org.example;
public class discount {
    private int d;
    private String code;
    public discount() {}
    public String getcode() {
        return code;
    }
    public void setcode(String code) {
        this.code = code;
    }
    public discount(int d , String code) {
        this.d = d;
        this.code = code;
    }
    public int getD() {
        return d;
    }
    public void setD(int d) {
        this.d = d;
    }
    public int getTickets() {
        return tickets;
    }
    public void setTickets(int tickets) {
        this.tickets = tickets;
    }
    private int tickets;
    public discount(int d, int tickets) {
        this.d = d;
        this.tickets = tickets;
    }
}
