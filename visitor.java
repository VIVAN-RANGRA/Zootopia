package org.example;
import java.util.ArrayList;
public interface visitor {
    void view_zoo(ArrayList<attraction> attractions,ArrayList<animal> animals);
    int Buy_tickets(ArrayList<attraction> attractions , ArrayList<discount> discounts,Member m , String name );
    void Visit_Animal(animal a, int choice);
    void Visit_Attractions(ArrayList<attraction> attractions, Member m);
    void Leave_Feeback(ArrayList<String> feedbacks, String feedback);
    void View_Discounts(ArrayList<discount> discounts);
    void View_Special_Deals(ArrayList<discount> special_deals);
}
