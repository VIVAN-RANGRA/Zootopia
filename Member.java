package org.example;
import java.util.ArrayList;
import java.util.Scanner;
public class Member extends Info  implements visitor {
    ArrayList<ticket> ticket_names = new ArrayList<>();
    @Override
    public void view_zoo(ArrayList<attraction> attractions, ArrayList<animal> animals) {
        for (attraction a : attractions) {
            System.out.println(a.getName());
            System.out.println(a.getDescription());
        }
        for (animal a : animals) {
            System.out.println(a.getName());
            System.out.println(a.getType());
        }
    }
    public ArrayList<ticket> getTicket_names() {
        return ticket_names;
    }
    @Override
    public int Buy_tickets(ArrayList<attraction> attractions, ArrayList<discount> discounts,Member m, String name) {
        int r = 0;
        System.out.print("Any discount CODE ? (code_name/no) : ");
        boolean codeFound = false;
        Scanner inp = new Scanner(System.in);
        String code = inp.nextLine();
        discount d1 = new discount(0,"no");
        for (discount d : discounts) {
            if (d.getcode().equals(code)) {
                codeFound = true;
                d1.setcode(d.getcode());
                d1.setD(d.getD());
            }
        }
        for (attraction a : attractions) {
            if (a.getName().equals(name)) {
                ticket temp = new ticket(1, a);
                if (m.getTicket_names().contains(temp)) {
                    System.out.println("You already have a ticket for this attraction");
                    return 0;
                } else if (m.getBalance() >= (a.getPrice()) ) {
                    if(codeFound){
                        r  += a.getPrice()* (1 - (d1.getD() / 100));
                    }else{
                        r += a.getPrice();
                    }
                }
                } else {
                    System.out.println("Insufficient balance");
                }
            }
        m.setBalance(m.getBalance() - r);
        return r;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    @Override
    public void Visit_Animal(animal a, int choice) {
        if (choice == 1) {
            System.out.println("Feeding the " + a.getName());
            System.out.println(a.getNoise());
        } else {
            System.out.println("Reading about the " + a.getName());
            System.out.println(a.getDescription());
        }
    }
    public Member(String name, String email, String password, int phone_number, int balance, int age) {
        super(name, email, password, phone_number, balance, age);
    }

    @Override
    public void Visit_Attractions(ArrayList<attraction> attractions, Member m) {
    Scanner inp = new Scanner(System.in);
    int i = 1;
    for (attraction a : attractions) {
        System.out.println(i + " " + a.getName());
        i++;
    }
    System.out.print("Enter the number of the attraction you want to visit : ");
    int choice4 = inp.nextInt();
    if (choice4 < 1 || choice4 > attractions.size()) {
        System.out.println("Invalid choice. Please select a valid attraction.");
        return;
    }
    attraction selectedAttraction = attractions.get(choice4 - 1);
    if (selectedAttraction.getState().equals("open")) {
        if (m.getType().equals("premium")) {
            System.out.println(selectedAttraction.getDescription());
            System.out.println("Thank you for visiting " + selectedAttraction.getName() + ". Hope you had a great time");
            attractions.get(choice4 - 1).setCount(attractions.get(choice4 - 1).getCount() + 1);
        } else {
            boolean hasTicket = false;
            for (ticket t : m.getTicket_names()) {
                if (t.getA().getName().equals(selectedAttraction.getName()) && t.getCount() > 0) {
                    System.out.println(selectedAttraction.getDescription());
                    System.out.println("Thank you for visiting " + selectedAttraction.getName() + ". Hope you had a great time");
                    attractions.get(choice4 - 1).setCount(attractions.get(choice4 - 1).getCount() + 1);
                    m.getTicket_names().remove(t);
                    hasTicket = true;
                    break;
                }
            }
            if (!hasTicket) {
                System.out.println("You do not have a ticket for this attraction");
            }
        }
    } else {
        System.out.println("Attraction is closed");
    }
}
    @Override
    public void Leave_Feeback(ArrayList<String> feedbacks, String feedback) {
        if (feedbacks != null) {
            if (feedback != null && !feedback.isEmpty()) {
                feedbacks.add(feedback);
                System.out.println("Feedback added successfully");
            } else {
                System.out.println("Invalid feedback");
            }
        } else {
            System.out.println("Error: feedbacks is null");
        }
    }
     @Override
    public void View_Discounts(ArrayList<discount> discounts) {
        for(discount d: discounts){
            System.out.println(d.getcode() + " " + d.getD() + "%" );
        }
    }
    @Override
    public void View_Special_Deals(ArrayList<discount> special_deals) {
        System.out.println("Special Deals are : ");
       for(discount d: special_deals){
           System.out.println("Buy " + d.getTickets() + " tickets and get a discount of " + d.getD() + "%");
       }
    }
  public int buy_special_deals(ArrayList<attraction> attractions, ArrayList<discount> discounts,ArrayList<discount> special_deals, Member m, int choice) {
    int r = 0;
    Scanner inp = new Scanner(System.in);
    for (discount d : special_deals) {
        if (d.getTickets() == choice) {
            for (int i = 0; i < choice; i++) {
                System.out.print("Enter the name of the attraction : ");
                String name = inp.nextLine();
                ticket temp = new ticket(1, new attraction(name));
                if (m.getTicket_names().contains(temp)) {
                    System.out.println("You already have a ticket for this attraction");
                    continue; // Use continue instead of break
                } else {
                    try {
                        boolean attractionFound = false;
                        for (attraction a : attractions) {
                            int discountedPrice = a.getPrice();
                            discount d1 = new discount(0,"no");
                            System.out.println("Any discount CODE ? (code_name/no) : ");
                            String code = inp.nextLine();
                            boolean codeFound = false;
                            if(code.equals("no")){
                                codeFound= false;
                            }else {
                                for (discount x : discounts) {
                                    if (x.getcode().equals(code)) {
                                        codeFound = true;
                                        d1.setcode(x.getcode());
                                        d1.setD(x.getD());
                                        break;
                                    }
                                }
                            }
                            if (a.getName().equals(name)) {
                                if (m.getBalance() >= a.getPrice()) {
                                    if (codeFound) {
                                        discountedPrice = (int) (a.getPrice() * (1 - (d.getD() / 100)) * (1 - (d1.getD() / 100)));
                                    }
                                    else {
                                        discountedPrice = (int) (a.getPrice() * (1 - (d.getD() / 100)));
                                    }
                                    if (m.getBalance() >= discountedPrice) {
                                        r += discountedPrice;
                                        m.setBalance(m.getBalance() - discountedPrice);
                                        ticket t = new ticket(1, a);
                                        m.getTicket_names().add(t);
                                        System.out.println("Ticket bought successfully");
                                        attractionFound = true;
                                        break; // Exit the loop when a valid attraction is found
                                    } else {
                                        System.out.println("Insufficient balance");
                                    }
                                }
                            }
                        }
                        if (!attractionFound) {
                            System.out.println("Attraction not found or not open");
                        }
                    } catch (Exception e) {
                        System.out.println("An error occurred while processing the attraction");
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    return r;
}
private String type = "basic" ;
}
