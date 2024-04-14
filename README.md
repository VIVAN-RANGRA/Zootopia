# Zootopia



In this assignment by using concepts of OOPS like polymorphism , inheritance  , interfaces as well as method overloading . 

In it there are 8 classes : 
1 ) Attraction - Name , description , state(open/closed) , price[DEFAULT = 20] and polpularity(as Count)
2 ) Animal - Name , description , noise and its type (mammal/amphibian/reptile) 
3 ) Info - name , age , email , password , balance and phone number . 
4 ) Ticket - Attraction , Count
5 ) Discount - d[percentage] , tickets , code
6 ) Member  - all functions of member menu , Ticket_name : for which attraction he/she has a ticket , extends
               from Info class so it has all its attribute , implemets visitor interface for all its methods
7 ) Admin - all functions of admin menu , id and password 
9 ) Main - Combines all functionalitiues 
The main function is the driver program that combines all other classes. It takes user input to decide what action to perform. The user can choose to enter as Admin , Member
   View Special deals or even exit 


Proper error handling has been used . 

Admins can manage attractions , open/close them or even update their prices , manage animals , manage/update special deals and discounts , can see total revenue , total number of people visited and 
most popular attraction . 

Members first need to register and then login to access member facilities . If wrong credentials  are there , then invalid credentials is printed . If put in correctly , then 
member can buy basic or premium membership . With premium , you dont have to buy tickets at all , you can visit all attractions . If you buy basic membership , then you have to buy tickets 
for any attraction you want to visit . Before buying a special deal or ticket for an  attraction , a user is asked if he know a discount code or not . If dicount code is in list of discounts , then discount
will be applied else not . 
