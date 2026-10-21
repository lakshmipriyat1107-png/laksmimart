package com.priyamart.priyamart.repository;
import com.priyamart.priyamart.model.Product;
import org.springframework.jdbc.core.JdbcTemplate; import org.springframework.jdbc.support.GeneratedKeyHolder; import org.springframework.jdbc.support.KeyHolder; import org.springframework.stereotype.Repository;
import java.sql.PreparedStatement; import java.sql.Statement; import java.util.List;
@Repository public class ProductRepository {
 private final JdbcTemplate jdbc; public ProductRepository(JdbcTemplate jdbc){this.jdbc=jdbc;}
 private final org.springframework.jdbc.core.RowMapper<Product> mapper=(rs,n)->new Product(rs.getLong("id"),rs.getString("name"),rs.getString("description"),rs.getBigDecimal("price"),rs.getString("category"),rs.getObject("seller_id",Long.class));
 public List<Product> findAll(){return jdbc.query("SELECT id,name,description,price,category,seller_id FROM products ORDER BY id DESC",mapper);}
 public Product create(Product p){KeyHolder h=new GeneratedKeyHolder();jdbc.update(c->{PreparedStatement ps=c.prepareStatement("INSERT INTO products(name,description,price,category,seller_id) VALUES(?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);ps.setString(1,p.name());ps.setString(2,p.description());ps.setBigDecimal(3,p.price());ps.setString(4,p.category());if(p.sellerId()==null)ps.setObject(5,null);else ps.setLong(5,p.sellerId());return ps;},h);long id=h.getKey().longValue();return jdbc.queryForObject("SELECT id,name,description,price,category,seller_id FROM products WHERE id=?",mapper,id);}
 public void delete(long id){jdbc.update("DELETE FROM products WHERE id=?",id);}
 public int count(){return jdbc.queryForObject("SELECT COUNT(*) FROM products",Integer.class);}
 public boolean exists(long id){Integer n=jdbc.queryForObject("SELECT COUNT(*) FROM products WHERE id=?",Integer.class,id);return n!=null&&n>0;}
}
