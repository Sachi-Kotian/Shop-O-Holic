package com.shopoholic.model;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class Order {
    private int orderId;
    private User user;
    private Cart cart;
    private double amount;
    private LocalDateTime orderDate;

    public Order(int orderId,User user,Cart cart)
    {
        this.orderId=orderId;
        this.user=user;
        this.cart=cart;
        this.amount=cart.getTotal();
        this.orderDate = LocalDateTime.now();



    }

    public void getOrderSummary()
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        System.out.println("Order ID  : " + orderId);
        System.out.println("Customer  : " + user.getUserName());
        System.out.println("Date      : " + orderDate.format(formatter));
        System.out.println("--- Items ---");
        cart.displayCart();
        System.out.println("Total     : Rs." + String.format("%.2f", amount));
    }

    public int getOrderId()
    {
        return this.orderId;
    }

    @Override
    public String toString() {
        return "[ " + orderId + " ] : " + user.getUserName() + " | Rs." + String.format("%.2f", amount);
    }

}
