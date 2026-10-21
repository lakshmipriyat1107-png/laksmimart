package com.priyamart.model;
public class User{
 private int id; private String name,email,password,role;
 public User(){} public User(int i,String n,String e,String p,String r){id=i;name=n;email=e;password=p;role=r;}
 public int getId(){return id;} public void setId(int v){id=v;} public String getName(){return name;} public void setName(String v){name=v;}
 public String getEmail(){return email;} public void setEmail(String v){email=v;} public String getPassword(){return password;} public void setPassword(String v){password=v;}
 public String getRole(){return role;} public void setRole(String v){role=v;}
}