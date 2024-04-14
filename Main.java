package org.example;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        ArrayList<attraction> attractions = new ArrayList<>();
        ArrayList<Member> members = new ArrayList<>();
        ArrayList<animal> animals = new ArrayList<>();
        ArrayList<String> feedback = new ArrayList<>();
        ArrayList<discount> discounts = new ArrayList<>();
        ArrayList<discount> special_deals = new ArrayList<>();
        discount d1 = new discount(10,"MINOR");
        discount d2 = new discount(20,"SENIOR");
        discounts.add(d1);
        discounts.add(d2);
        discount special_deal_1 = new discount(15, 2);
        special_deals.add(special_deal_1);
        discount special_deal_2 = new discount(30,3);
        special_deals.add(special_deal_2);
        int total_visitors = members.size();
        int total_revenue = 0;
        boolean exit = false;
        while (!exit) {
            System.out.println("""
                    Welcome to ZOOtopia!
                    Please choose one of the following options:
                    1. Enter as Admin
                    2. Enter as a Visitor
                    3. View Special Deals
                    4. Exit
                    """);
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter your choice : ");
            int choice = sc.nextInt();
            if (choice == 1) {
                    Admin admin = new Admin();
                    admin.setId("vivan");
                    admin.setPassword("1234");
                    String id, password;
                    System.out.print("Enter your id : ");
                    id = sc.next();
                    System.out.print("Enter your password : ");
                    password = sc.next();
                    if (id.equals(admin.getId()) && password.equals(admin.getPassword())) {
                        boolean admin_exit = false;
                        while (!admin_exit) {
                            System.out.println("""
                                    Logged in as Admin.
                                    Admin Menu:
                                    1. Manage Attractions
                                    2. Manage Animals
                                    3. Schedule Events
                                    4. Set Discounts
                                    5. Set Special Deal
                                    6. View Visitor Stats
                                    7. View Feedback
                                    8. Exit
                                    """);
                            System.out.print("Enter your choice : ");
                            int choice1 = sc.nextInt();
                            if (choice1 == 1) {
                                boolean e = false;
                                while (!e) {
                                System.out.println("""
                                        Manage Attractions:
                                        1. Add Attraction
                                        2. View Attractions
                                        3. Modify Attraction
                                        4. Remove Attraction
                                        5. Exit
                                        """);
                                System.out.print("Enter your choice : ");
                                int choice2 = sc.nextInt();
                                if (choice2 == 1) {
                                    System.out.print("Enter the name of the attraction : ");
                                    String name = sc.next();
                                    System.out.print("Enter the description of the attraction : ");
                                    String description = sc.next();
                                    admin.add_attraction(attractions, name, description);
                                } else if (choice2 == 2) {
                                    admin.view_attraction(attractions);
                                } else if (choice2 == 3) {
                                    admin.modify_attraction(attractions);
                                } else if (choice2 == 4) {
                                    System.out.print("Enter the name of the attraction to be removed : ");
                                    String name = sc.next();
                                    admin.remove_attraction(attractions, name);
                                } else if (choice2 == 5) {
                                    e = true;
                                }
                                }
                            } else if (choice1 == 2) {
                                boolean e = false;
                                while (!e) {
                                    System.out.println("""
                                            Manage Animals:
                                            1. Add Animal
                                            2. Update Animal Details\s
                                            3. Remove Animal
                                            4. Exit
                                            """);
                                    System.out.print("Enter your choice : ");
                                    int choice2 = sc.nextInt();
                                    if (choice2 == 1) {
                                        System.out.print("Enter the name of the animal : ");
                                        String name = sc.next();
                                        System.out.print("Enter the type of the animal : ");
                                        String type = sc.next();
                                        admin.add_animal(animals, name, type);
                                    } else if (choice2 == 2) {
                                        admin.update_animal(animals);
                                    } else if (choice2 == 3) {
                                        System.out.print("Enter the name of the animal to be removed : ");
                                        String name = sc.next();
                                        admin.remove_animal(animals, name);
                                    } else if (choice2 == 4) {
                                        e = true;
                                    }
                                }
                            } else if (choice1 == 3) {
                                boolean e = false;
                                while (!e) {
                                    System.out.println("""
                                            Schedule Events:
                                            1. Open attraction
                                            2. Close attraction
                                            3. Price entry\s
                                            4. Exit
                                            """);
                                    System.out.print("Enter your choice : ");
                                    int choice2 = sc.nextInt();
                                    if (choice2 == 1) {
                                        System.out.print("Enter the name of the attraction : ");
                                        String name = sc.next();
                                        admin.open_attraction(attractions, name);
                                    } else if (choice2 == 2) {
                                        System.out.print("Enter the name of the attraction : ");
                                        String name = sc.next();
                                        admin.close_attraction(attractions, name);
                                    } else if (choice2 == 3) {
                                        System.out.print("Enter the name of the attraction : ");
                                        String name = sc.next();
                                        System.out.print("Enter the price of the attraction : ");
                                        int price = sc.nextInt();
                                        admin.price_entry(attractions, name, price);
                                    } else if (choice2 == 4) {
                                        e = true; // exit the current menu and return to the admin menu
                                    }
                                }
                            } else if (choice1 == 4) {
                                boolean e = false;
                                while(!e) {
                                    for(discount d : discounts){
                                        System.out.println(d.getcode()+" "+d.getD());
                                    }
                                    System.out.println("""
                                            Set Discounts:
                                            1. Add  Discount
                                            2. Modify Discount
                                            3.Remove Discount
                                            4. Exit
                                            """);
                                    System.out.print("Enter your choice : ");
                                    int choice2 = sc.nextInt();
                                    if (choice2 == 1) {
                                        System.out.print("Enter  Discount % : ");
                                        int d = sc.nextInt();
                                        System.out.print("Enter  Discount name : ");
                                        String name = sc.next();
                                        discount dis = new discount(d, name);
                                        discounts.add(dis);
                                    } else if (choice2 == 2) {
                                        System.out.print("Enter Discount Name : ");
                                        String name = sc.next();
                                        System.out.print("Enter Discount Value : ");
                                        int d = sc.nextInt();
                                        admin.modify_discount(discounts, name, d);
                                    } else if (choice2 == 3) {
                                        System.out.print("Enter name of discount to be removed : ");
                                        String name = sc.next();
                                        admin.remove_discount(discounts, name);
                                    } else {
                                        e = true;
                                    }
                                }
                            } else if (choice1 == 6) {
                                System.out.println("Total number  of visitors : " + total_visitors);
                                System.out.println("Total revenue : " + total_revenue);
                                 attraction m_a = new attraction();
                                for (attraction a : attractions) {
                                    if (a.getCount() > m_a.getCount()) {
                                        m_a.setName(a.getName());
                                    }
                                    System.out.println("Most visited attraction : " + m_a.getName());
                                }
                            } else if (choice1 == 5) {
                                System.out.print("Enter the number of tickets : ");
                                int tickets = sc.nextInt();
                                System.out.print("Enter the discount % : ");
                                int d = sc.nextInt();
                                admin.set_special_deals(special_deals, d, tickets);
                            } else if (choice1 == 8) {
                                admin_exit = true;   // exit the program
                            } else if (choice1 == 7) {
                                if(feedback.isEmpty()){
                                    System.out.println("No feedbacks");
                                }else {
                                    for (String a : feedback) {
                                        System.out.println(a);
                                    }
                                }
                            }
                        }
                    } else {
                        System.out.println("Invalid Credentials!");
                    }
                }
            else if(choice == 2) {
                boolean user_exit_1 = false;
                while (!user_exit_1) {
                    System.out.print("""
                            1. Register
                            2. Login
                            3 .Exit
                            """);
                    System.out.print("Enter your choice : ");
                    int choice1 = sc.nextInt();
                    if (choice1 == 1) {
                        String name  ;
                        int age ;
                        String email ;
                        String password ;
                        int phone_number ;
                        int balance ;
                        System.out.print("Enter your name: ");
                        if (sc.hasNext()) {
                            name = sc.next();
                        } else {
                            System.out.println("Invalid name input.");
                            return;
                        }
                        System.out.print("Enter your age: ");
                        if (sc.hasNextInt()) {
                            age = sc.nextInt();
                        } else {
                            System.out.println("Invalid age input.");
                            return;
                        }
                        System.out.print("Enter your email: ");
                        if (sc.hasNext()) {
                            email = sc.next();
                        } else {
                            System.out.println("Invalid email input.");
                            return;
                        }
                        System.out.print("Enter your password: ");
                        if (sc.hasNext()) {
                            password = sc.next();
                        } else {
                            System.out.println("Invalid password input.");
                            return;
                        }
                        System.out.print("Enter your phone number: ");
                        if (sc.hasNextInt()) {
                            phone_number = sc.nextInt();
                        } else {
                            System.out.println("Invalid phone number input.");
                            return;
                        }
                        System.out.print("Enter your balance: ");
                        if (sc.hasNextInt()) {
                            balance = sc.nextInt();
                        } else {
                            System.out.println("Invalid balance input.");
                            return;
                        }
                        Member m = new Member(name, email, password, phone_number, balance, age);
                        members.add(m);
                        System.out.println("Registered successfully!");
                    } else if (choice1 == 2) {
                        System.out.print("Enter your email : ");
                        String email = sc.next();
                        System.out.print("Enter your password : ");
                        String password = sc.next();
                        for (Member m : members) {
                            if (m.getEmail().equals(email) && m.getPassword().equals(password)) {
                                boolean user_exit = false;
                                total_visitors += 1;
                                while (!user_exit) {
                                    System.out.println("""
                                            Logged in as Member.
                                            Member Menu:
                                            1. Explore the Zoo
                                            2. Buy Membership/Increase Balance
                                            3. Buy Tickets
                                            4. View Discounts
                                            5. View Special Deals
                                            6. Visit Animal
                                            7. Visit Attractions
                                            8. Leave Feedback
                                            9. Log Out
                                            """);
                                    System.out.print("Enter your choice : ");
                                    int choice2 = sc.nextInt();
                                    if (choice2 == 1) {
                                        System.out.println("What do you want to do ? ");
                                        System.out.println("""
                                                1. View Attractions
                                                2. View Animals
                                                3. Exit
                                                """);
                                        System.out.print("Enter your choice : ");
                                        int choice3 = sc.nextInt();
                                        if (choice3 == 1) {
                                            m.Visit_Attractions(attractions, m);
                                        } else if (choice3 == 2) {
                                            for (animal a : animals) {
                                                System.out.println(a.getName());
                                            }
                                            System.out.println("Enter the name of the animal : ");
                                            String name = sc.next();
                                            for (animal a : animals) {
                                                if (a.getName().equals(name)) {
                                                    System.out.println("""
                                                            1. Feed the animal
                                                            2. Read about the animal
                                                            """);
                                                    System.out.print("Enter your choice : ");
                                                    int choice4 = sc.nextInt();
                                                    m.Visit_Animal(a, choice4);
                                                }
                                            }
                                        } else if (choice3 == 3) {
                                            break;
                                        }
                                    } else if (choice2 == 2) {
                                        System.out.println("""
                                                Buy Membership:
                                                1. Basic Membership (₹20)
                                                2. Premium Membership (₹50)
                                                3. Increase Balance
                                                4. Exit
                                                """);
                                        System.out.print("Enter your choice : ");
                                        int choice3 = sc.nextInt();
                                        if (choice3 == 1) {
                                            m.setBalance(m.getBalance() - 20);
                                            System.out.println("Membership bought successfully");
                                            m.setType("basic");
                                            total_revenue += 20;
                                            System.out.println("Total revenue after purchase: " + total_revenue);
                                        } else if (choice3 == 2) {
                                            m.setBalance(m.getBalance() - 50);
                                            System.out.println("Membership bought successfully");
                                            m.setType("premium");
                                            total_revenue += 50;
                                             System.out.println("Total revenue after purchase: " + total_revenue);
                                        } else if (choice3 == 3) {
                                            System.out.print("Enter the amount to be added : ");
                                            int amount = sc.nextInt();
                                            m.setBalance(m.getBalance() + amount);
                                            System.out.println("Balance added successfully");
                                        } else {
                                            break;
                                        }
                                    } else if (choice2 == 3) {
                                        int i = 1;
                                        for (attraction a : attractions) {
                                            System.out.println(i + ")" + a.getName());
                                            i++;
                                        }
                                        if (m.getType().equals("premium")) {
                                            System.out.println("No need to buy tickets");
                                        } else {
                                            System.out.print("Enter the name of the attraction");
                                            String name = sc.next();
                                            int r =  m.Buy_tickets(attractions, discounts,m, name);
                                            total_revenue = total_revenue+r;
                                        }
                                    } else if (choice2 == 6) {
                                        System.out.print("Enter the name of the animal");
                                        String name = sc.next();
                                        for (animal a : animals) {
                                            if (a.getName().equals(name)) {
                                                System.out.println("""
                                                        1. Feed the animal
                                                        2. Read about the animal
                                                        """);
                                                System.out.print("Enter your choice : ");
                                                int choice3 = sc.nextInt();
                                                m.Visit_Animal(a, choice3);
                                            }
                                        }
                                    } else if (choice2 == 7) {
                                        m.Visit_Attractions(attractions, m);
                                    } else if (choice2 == 8) {
                                        System.out.print("Enter your feedback : ");
                                        String f = sc.next();
                                        m.Leave_Feeback(feedback, f);
                                    } else if (choice2 == 4) {
                                        m.View_Discounts(discounts);
                                    } else if (choice2 == 5) {
                                        if (m.getType().equals("premium")) {
                                            System.out.println("No special deals required for premium members");
                                        } else {
                                            m.View_Special_Deals(special_deals);
                                            System.out.print("Enter the number of tickets : ");
                                            int count = sc.nextInt();
                                            int rev = m.buy_special_deals(attractions, discounts,special_deals, m, count);
                                            total_revenue += rev;
                                        }
                                    } else if (choice2 == 9) {
                                        user_exit = true;
                                    }
                                }
                            } else {
                                System.out.println("Invalid Credentials");
                            }
                        }
                    } else if (choice1 == 3) {
                        user_exit_1 = true;
                    }
                }
            }
            else if(choice ==3){
                for(discount d : special_deals){
                    System.out.println("Buy " + d.getTickets() + " tickets and get a discount of " + d.getD() + "%");
                }
            }
            else{
                exit = true;
            }
           }
       }
   }