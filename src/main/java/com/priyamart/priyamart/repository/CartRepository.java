package com.priyamart.priyamart.repository;
import com.priyamart.priyamart.model.CartItem; import org.springframework.jdbc.core.JdbcTemplate; import org.springframework.stereotype.Repository; import java.util.List;
@Repository public class CartRepository {
 private final JdbcTemplate jdbc; public CartRepository(JdbcTemplate jdbc){this.jdbc=jdbc;}
 public void add(long userId,long productId){jdbc.update("INSERT INTO cart_items(user_id,product_id) VALUES(?,?)",userId,productId);}
 public List<CartItem> findByUser(long userId){return jdbc.query("SELECT c.id,c.user_id,c.product_id,p.name,p.price FROM cart_items c JOIN products p ON p.id=c.product_id WHERE c.user_id=? ORDER BY c.id DESC",(rs,n)->new CartItem(rs.getLong("id"),rs.getLong("user_id"),rs.getLong("product_id"),rs.getString("name"),rs.getBigDecimal("price")),userId);}
 public void delete(long id){jdbc.update("DELETE FROM cart_items WHERE id=?",id);}
}
