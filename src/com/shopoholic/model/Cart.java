package com.shopoholic.model;


import java.util.HashMap;
import java.util.Map;

public class Cart {
    private HashMap<Product,Integer> cart;



    public Cart()
    {
        cart=new HashMap<>();

    }

    public void addToCart(Product p,int quantity)
    {
        if(quantity<=p.getStock()) {
            cart.put(p, quantity);
        }
        else {
            System.out.println("Insufficient stock");
        }
    }

    public void removeItem(int productId){

        cart.keySet().removeIf(p->p.getProductId()==productId);
    }

    public void displayCart()
    {
        for(Map.Entry<Product,Integer> item:cart.entrySet())
        {
            System.out.println(item.getKey().getProductName() +
                    " x" + item.getValue() +
                    " | Rs." + String.format("%.2f",
                    item.getKey().getPrice() * item.getValue()));

        }
    }

    public void generateBill()
    {
        double bill=0;
        for(Map.Entry<Product,Integer> item:cart.entrySet())
        {
            bill+=item.getKey().getPrice()*item.getValue();
        }

        System.out.println("Total bill : Rs." + String.format("%.2f", bill));

    }

    public void updateQuantity(int productId,int quantity)
    {
        for(Map.Entry<Product,Integer> item:cart.entrySet())
        {
            if(item.getKey().getProductId()==productId)
            {
                item.setValue(quantity);
                return;
            }
        }
        System.out.println("Product Not In Cart");
    }

    public double getTotal() {
        double total = 0;
        for(Map.Entry<Product,Integer> item : cart.entrySet()) {
            total += item.getKey().getPrice() * item.getValue();
        }
        return total;
    }

}
