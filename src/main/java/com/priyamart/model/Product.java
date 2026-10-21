package com.priyamart.model;

public class Product {
    private int id, stock;
    private String name, description, category, imageUrl;
    private double price;
    public Product() {}
    public Product(int id, String name, String description, String category, double price, int stock, String imageUrl) {
        this.id=id; this.name=name; this.description=description; this.category=category; this.price=price; this.stock=stock; this.imageUrl=imageUrl;
    }
    public int getId(){return id;} public void setId(int v){id=v;}
    public String getName(){return name;} public void setName(String v){name=v;}
    public String getDescription(){return description;} public void setDescription(String v){description=v;}
    public String getCategory(){return category;} public void setCategory(String v){category=v;}
    public double getPrice(){return price;} public void setPrice(double v){price=v;}
    public int getStock(){return stock;} public void setStock(int v){stock=v;}
    public String getImageUrl(){return imageUrl;} public void setImageUrl(String v){imageUrl=v;}
}
