package com.priyamart.repository;
import com.priyamart.model.Product; import org.springframework.jdbc.core.JdbcTemplate; import org.springframework.stereotype.Repository; import java.util.List;
@Repository public class ProductRepository {
 private final JdbcTemplate db; public ProductRepository(JdbcTemplate d){db=d;}
 private final org.springframework.jdbc.core.RowMapper<Product> m=(r,n)->new Product(r.getInt("id"),r.getString("name"),r.getString("description"),r.getString("category"),r.getDouble("price"),r.getInt("stock"),r.getString("image_url"));
 public List<Product> all(){return db.query("SELECT * FROM products ORDER BY id DESC",m);}
 public List<Product> search(String q,String category){String x=q==null?"":q.trim();String c=category==null?"":category.trim();return db.query("SELECT * FROM products WHERE (?='' OR LOWER(name) LIKE LOWER(?) OR LOWER(description) LIKE LOWER(?)) AND (?='' OR category=?) ORDER BY id DESC",m,x,"%"+x+"%","%"+x+"%",c,c);}
 public List<String> categories(){return db.queryForList("SELECT DISTINCT category FROM products ORDER BY category",String.class);}
 public Product one(int id){return db.queryForObject("SELECT * FROM products WHERE id=?",m,id);}
 public void add(Product p){db.update("INSERT INTO products(name,description,category,price,stock,image_url) VALUES(?,?,?,?,?,?)",p.getName(),p.getDescription(),p.getCategory(),p.getPrice(),p.getStock(),p.getImageUrl());}
 public void delete(int id){db.update("DELETE FROM products WHERE id=?",id);}
 public int count(){return db.queryForObject("SELECT COUNT(*) FROM products",Integer.class);}
 public int lowStock(){return db.queryForObject("SELECT COUNT(*) FROM products WHERE stock<10",Integer.class);}
}
