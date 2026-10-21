package com.priyamart.repository;
import com.priyamart.model.User; import org.springframework.jdbc.core.JdbcTemplate; import org.springframework.stereotype.Repository;
@Repository public class UserRepository{
 private final JdbcTemplate db; public UserRepository(JdbcTemplate d){db=d;}
 private final org.springframework.jdbc.core.RowMapper<User> m=(r,n)->new User(r.getInt("id"),r.getString("name"),r.getString("email"),r.getString("password"),r.getString("role"));
 public User login(String e,String p){var x=db.query("SELECT * FROM users WHERE email=? AND password=?",m,e,p);return x.isEmpty()?null:x.get(0);}
 public boolean exists(String e){Integer n=db.queryForObject("SELECT COUNT(*) FROM users WHERE email=?",Integer.class,e);return n!=null&&n>0;}
 public void register(String n,String e,String p){db.update("INSERT INTO users(name,email,password,role) VALUES(?,?,?,'CUSTOMER')",n,e,p);}
}