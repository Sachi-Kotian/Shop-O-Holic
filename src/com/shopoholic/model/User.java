package com.shopoholic.model;
import java.util.List;
import java.util.ArrayList;

public class User {
    private int userId;
    private String userName;
    private String password;
    private String email;
    private List<Product> wishlist;

    public User(int userId,String userName,String password,String email)
    {
        this.userId=userId;
        this.userName=userName;
        this.password=password;
        this.email=email;
        wishlist=new ArrayList<>();
    }

    public int getUserId()
    {
        return this.userId;

    }

    public String getUserName()
    {
        return this.userName;
    }

    public String getPassword()
    {
        return this.password;
    }

    public String getEmail()
    {
        return this.email;
    }

    public void addWishlist(Product p)
    {
        wishlist.add(p);
    }

    public void displayWishList()
    {
        for(Product p:wishlist)
        {
            System.out.println(p);
        }
    }

    @Override
    public String toString()
    {
        return "[ "+userId+" ] : "+userName+
                "| "+email;
    }

}