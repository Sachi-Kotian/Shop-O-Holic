package com.shopoholic.model;

public class Product {

    private int productId;
    private String productName;
    private String category;
    private double price;
    private int stock;

    public Product(int productId,String productName,String category,double price,int stock)
    {
        this.productId=productId;
        this.productName=productName;
        this.category=category;
        this.price=price;
        this.stock=stock;
    }

    public int getProductId()
    {
        return this.productId;
    }
    public String getProductName()
    {
        return this.productName;
    }
    public String getCategory()
    {
        return this.category;
    }
    public double getPrice()
    {
        return this.price;
    }
    public int getStock()
    {
        return this.stock;
    }

    public void setStock(int stock)
    {
        this.stock=stock;
    }

    @Override
    public String toString()
    {
        return "[ "+productId+" ] : "+productName+
                "| Rs."+String.format("%.2f",price)+
                "| "+category+
                "| "+stock+" left ";
    }


}
