package com.priyamart.model;
import java.time.LocalDateTime;
public class Order {
    private int id; private double total; private String status, shippingAddress; private LocalDateTime createdAt;
    public Order() {}
    public Order(int id,double total,String status,String shippingAddress,LocalDateTime createdAt){this.id=id;this.total=total;this.status=status;this.shippingAddress=shippingAddress;this.createdAt=createdAt;}
    public int getId(){return id;} public double getTotal(){return total;} public String getStatus(){return status;} public String getShippingAddress(){return shippingAddress;} public LocalDateTime getCreatedAt(){return createdAt;}
}
