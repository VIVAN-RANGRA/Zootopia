package org.example;

public class Info {
    private  String name ;
    private String email ;
    private String password ;
    private int phone_number ;
    private int balance ;

    public Info(String name, String email, String password, int phone_number, int balance, int age) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone_number = phone_number;
        this.balance = balance;
        this.age = age;
    }
    public Info(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(int phone_number) {
        this.phone_number = phone_number;
    }

    public int getBalance() {
        return balance;
    }
    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    private int age ;

}
