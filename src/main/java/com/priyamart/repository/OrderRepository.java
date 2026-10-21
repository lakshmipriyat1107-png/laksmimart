package com.priyamart.repository;
import com.priyamart.model.*; import org.springframework.jdbc.core.JdbcTemplate; import org.springframework.stereotype.Repository; import java.util.*;
@Repository public class OrderRepository {
 private final JdbcTemplate db; public OrderRepository(JdbcTemplate d){db=d;}
 public int create(User user,List<CartItem> cart,String address){double total=cart.stream().mapToDouble(CartItem::getTotal).sum();db.update("INSERT INTO orders(user_id,total,status,shipping_address) VALUES(?,?, 'PLACED',?)",user.getId(),total,address);Integer id=db.queryForObject("SELECT LAST_INSERT_ID()",Integer.class);for(CartItem i:cart){db.update("INSERT INTO order_items(order_id,product_id,product_name,quantity,price) VALUES(?,?,?,?,?)",id,i.getProduct().getId(),i.getProduct().getName(),i.getQuantity(),i.getProduct().getPrice());db.update("UPDATE products SET stock=GREATEST(stock-?,0) WHERE id=?",i.getQuantity(),i.getProduct().getId());}return id;}
 public List<Order> byUser(int uid){return db.query("SELECT * FROM orders WHERE user_id=? ORDER BY created_at DESC",(r,n)->new Order(r.getInt("id"),r.getDouble("total"),r.getString("status"),r.getString("shipping_address"),r.getTimestamp("created_at").toLocalDateTime()),uid);}
 public int count(){return db.queryForObject("SELECT COUNT(*) FROM orders",Integer.class);}
 public double revenue(){Double x=db.queryForObject("SELECT COALESCE(SUM(total),0) FROM orders",Double.class);return x==null?0:x;}
}
