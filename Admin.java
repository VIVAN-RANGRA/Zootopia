package org.example;
import java.util.ArrayList;
import java.util.Scanner;
public class Admin {
    private String id;
    private String password;
    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public void add_attraction(ArrayList<attraction> attractions, String name, String description){
        if (attractions.contains(new attraction(name))) {
            throw new IllegalArgumentException("Attraction already exists");
        }
        attraction a = new attraction(name);
        a.setDescription(description);
        attractions.add(a);
        System.out.println("Attraction added successfully");
    }
    public void view_attraction(ArrayList<attraction> attractions){
        if(attractions.isEmpty()) {
            System.out.println("No attractions currently available");

        }else {
            System.out.println("The attractions are:");
            for (attraction a : attractions) {
                System.out.println(a.getName());
            }
        }
    }
    public void modify_attraction(ArrayList<attraction> attractions){
        Scanner inp = new Scanner(System.in);
        System.out.print("Enter the name of the attraction : ");
        String name = inp.next();
        boolean attractionFound = false;
        for(attraction a: attractions){
            if(a.getName().equals(name)){
                System.out.print("Enter the new name of the attraction : ");
                String new_name = inp.next();
                System.out.print("Enter the new description of the attraction : ");
                String new_description = inp.next();
                attraction newAttraction = new attraction(new_name);
                newAttraction.setDescription(new_description);
                attractions.set(attractions.indexOf(a), newAttraction);
                attractionFound = true;
                System.out.println("Attraction updated successfully");
                break;
            }
        }
        if (!attractionFound) {
            throw new IllegalArgumentException("Attraction not found");
        }
    }
    public void remove_attraction(ArrayList<attraction> attractions, String name){
        attractions.removeIf(a -> a.getName().equals(name));
        System.out.println("Attraction removed successfully");
    }
    public void add_animal(ArrayList<animal> animals , String name ,String type ){
        Scanner inp = new Scanner(System.in);
        if(animal.isType(type)){
        boolean animalExists = animals.stream().anyMatch(animal -> animal.getName().equals(name));
        if (animalExists) {
            System.out.println("Animal with the same name already exists");
            return;
        }
        animal a = new animal(name,type);
        System.out.print("Write animal noise : ");
        String noise = inp.next();
        a.setNoise(noise);
        System.out.print("Write animal description : ");
        String description = inp.next();
        a.setDescription(description);
        animals.add(a);
        System.out.println("Animal added successfully");
        }
        else{
            throw new IllegalArgumentException("Invalid type");
        }
    }
    public void update_animal(ArrayList<animal> animals){
        Scanner inp = new Scanner(System.in);
        System.out.println("Enter the name of the animal");
        String name = inp.next();
        boolean animalFound = false;
        for(animal a: animals){
            if(a.getName().equals(name)){
                System.out.print("Enter the new name of the animal : ");
                String new_name = inp.next();
                a.setName(new_name);
                System.out.print("Enter the new type of the animal : ");
                String new_type = inp.next();
                if (a.isType(new_type)) {
                    a.setType(new_type);
                } else {
                    throw new IllegalArgumentException("Invalid type");
                }
                System.out.print("Enter the new code of the animal : ");
                String new_description = inp.next();
                a.setDescription(new_description);
                System.out.print("Enter the new noise of the animal : ");
                String new_noise = inp.next();
                a.setNoise(new_noise);
                System.out.println("Animal updated successfully");
                animalFound = true;
                break;
            }
        }
        if (!animalFound) {
            throw new IllegalArgumentException("Animal not found");
        }
    }
    public void remove_animal(ArrayList<animal> animals,String name){
        boolean animalRemoved = animals.removeIf(a -> a.getName().equals(name));
        if (!animalRemoved) {
            System.out.println("Animal not found");
        }else{
            System.out.println("Animal removed successfully");
        }
    }
    public void open_attraction(ArrayList<attraction> attractions,String name) {
        boolean attractionFound = false;
        for (attraction a : attractions) {
            if (a.getName().equals(name)) {
                a.setState("open");
                attractionFound = true;
                break;  // You can break out of the loop once you've found the attraction.
            }
        }
        if (attractionFound) {
            System.out.println("Attraction opened successfully.");
        }
        else {
        System.out.println("Attraction not found.");
        }
    }
    public void close_attraction(ArrayList<attraction> attractions, String name) {
    boolean attractionFound = false;
    for (attraction a : attractions) {
        if (a.getName().equals(name)) {
            a.setState("closed");
            attractionFound = true;
            break;  // You can break out of the loop once you've found the attraction.
        }
    }
    if (attractionFound) {
        System.out.println("Attraction closed successfully.");
    } else {
        System.out.println("Attraction not found.");
    }
}
    public void price_entry(ArrayList<attraction> attractions, String name, int price) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Invalid attraction name");
        }
        boolean attractionFound = false;
        for (attraction a : attractions) {
            if (a.getName().equals(name)) {
                a.setPrice(price);
                attractionFound = true;
                System.out.println("Price updated successfully");
                break;
            }
        }
        if (!attractionFound) {
            throw new IllegalArgumentException("Attraction not found");
        }
    }
    public void modify_discount(ArrayList<discount> discounts, String name, int new_d) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Invalid name");
        }
        if (new_d < 0) {
            throw new IllegalArgumentException("Invalid discount value");
        }
        boolean discountFound = false;
        for (discount x : discounts) {
            if (x.getcode().equals(name)) {
                x.setD(new_d);
                discountFound = true;
                System.out.println("Discount Updated Successfully");
                break;
            }
        }
        if (!discountFound) {
            throw new IllegalArgumentException("Discount not found");
        }
    }
    public void remove_discount(ArrayList<discount> discounts,String name){
        discounts.removeIf(x -> x.getcode().equals(name));
        System.out.println("Discount removed successfully");
    }
    public void set_special_deals(ArrayList<discount> specialDeals,int d ,int t){
        if (d <= 0 || t <= 0) {
            throw new IllegalArgumentException("Invalid discount or ticket value");
        }
        discount s = new discount(d,t);
        for( discount x : specialDeals ){
            if(x.getTickets() == t){
                System.out.print("Special deal already exists for this number of tickets , Do you want to  update  it?");
                String choice = new Scanner(System.in).next();
                if(choice.equals("yes")){
                    x.setD(d);
                    System.out.println("Special deal updated successfully");
                    return;
                }
                else{
                    System.out.println("Special deal not updated");
                    return;
                }
            }
        }
        specialDeals.add(s);
        System.out.println("Special deal added successfully");
    }
    public void remove_special_deals(ArrayList<discount> specialDeals,int d ,int t){
        specialDeals.removeIf(x -> x.getD() == d && x.getTickets() == t);
        System.out.println("Special deal removed successfully");
    }
}