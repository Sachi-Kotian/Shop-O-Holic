package com.shopoholic;
import com.shopoholic.model.*;
import com.shopoholic.service.*;

import java.util.Optional;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);

    List<User> users=new ArrayList<>();
    User loggedInUser=null;
    Cart cart=new Cart();

    Product p1=new Product(100,"Notebook","Stationary",100,50);
    Product p2=new Product(101,"HeadPhones","Electronics",4999,20);
    Product p3=new Product(103,"Dinner Set","Kitchen Ware",500,13);
    Product p4=new Product(104,"Sheet Mask","Skin Care",75,21);
    Product p5=new Product(105,"Study desk","Furniture",2499,3);
    Product p6=new Product(106,"Wireless Mouse","Electronics",320,12);
    Product p7=new Product(107,"Rubber Duck","Toys",50,33);

    ProductCatalog pd=new ProductCatalog();
    pd.addProducts(p1);
    pd.addProducts(p2);
    pd.addProducts(p3);
    pd.addProducts(p4);
    pd.addProducts(p5);
    pd.addProducts(p6);
    pd.addProducts(p7);

    int choice;

    System.out.println("WELCOME TO SHOP-O-HOLIC");
    int orderCount=1000;
    while(true)
    {


        System.out.println("***User Menu**");
        System.out.println("1.Register\n2.Login\n3.Browse Products\n4.Search Products\n5.Add To cart\n6.View Cart\n7.Add to WishList\n8.Checkout\n9.Exit");
        System.out.println("Enter a choice");
        choice=sc.nextInt();
        sc.nextLine();
        switch(choice){
            case 1:
                System.out.println("Enter your name");
                String name=sc.nextLine();
                System.out.println("Enter your email ID");
                String email=sc.next();
                System.out.println("Enter you password");
                String password=sc.next();
                int userId=users.size()+1;

                users.add(new User(userId,name,password,email));
                System.out.println("Registered successfully,Your ID is:"+userId);

                break;
            case 2:
                System.out.println("Enter your email");
                String mail=sc.next();
                System.out.println("Enter you password");
                String pass=sc.next();
                loggedInUser =null;
                for(User u:users) {

                    if (u.getEmail().equals(mail) && u.getPassword().equals(pass)) {
                        System.out.println("Logged in");
                        loggedInUser=u;
                        break;
                    }
                }
                if (loggedInUser == null )
                {
                    System.out.println("Invalid credentials");

                }

                break;
            case 3:

                pd.displayProduct();

                break;
            case 4:

                System.out.println("Search by Category(1) or Name(2)");
                int search=sc.nextInt();
                sc.nextLine();
                if(search==1)
                {
                    System.out.println("Enter category");
                    String category=sc.nextLine();
                    pd.filterByCategory(category);
                }
                else if(search==2)
                {
                    System.out.println("Enter Name of Product");
                    String product=sc.nextLine();
                    pd.filterByName(product);
                }
                else {
                    System.out.println("Invalid number choice");
                }

                break;
            case 5:

                if(loggedInUser == null) {
                    System.out.println("Please login first");
                    break;
                }
                System.out.println("Enter product ID");
                int id=sc.nextInt();
                System.out.println("Enter quantity");
                int quantity=sc.nextInt();
                Optional<Product> pr=pd.idToProduct(id);

                if(pr.isPresent())
                {
                    cart.addToCart(pr.get(),quantity);
                }
                else
                {
                    System.out.println("Product does not exist");
                }

                break;
            case 6:
                cart.displayCart();

                break;
            case 7:
                if(loggedInUser == null) {
                    System.out.println("Please login first");
                    break;
                }
                System.out.println("Enter product ID of product to be wishlisted");
                int prID=sc.nextInt();
                Optional<Product> p=pd.idToProduct(prID);

                if(p.isPresent())
                {
                 loggedInUser.addWishlist(p.get());

                }
                else {
                    System.out.println("Product does not exist");
                }

                break;
            case 8:
                if(loggedInUser == null) {
                    System.out.println("Please login first");
                    break;
                }

                int orderId=orderCount++;

                Order o=new Order(orderId,loggedInUser,cart);
                o.getOrderSummary();
                cart=new Cart();


                break;
            case 9:
                System.out.println("Thank you for Shopping");
                System.exit(0);
            default:
                System.out.println("Enter A Valid Choice");

        }
    }
    }
}
