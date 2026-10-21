package com.priyamart.priyamart.repository;
import com.priyamart.priyamart.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional;
@Repository public class UserRepository {
 private final JdbcTemplate jdbc; public UserRepository(JdbcTemplate jdbc){this.jdbc=jdbc;}
 public Optional<User> findByEmail(String email){List<User> x=jdbc.query("SELECT id,name,email,role FROM users WHERE email=?", (rs,n)->new User(rs.getLong("id"),rs.getString("name"),rs.getString("email"),rs.getString("role")),email);return x.stream().findFirst();}
 public Optional<User> findLogin(String email,String password,String role){List<User> x=jdbc.query("SELECT id,name,email,role FROM users WHERE email=? AND password=? AND role=?",(rs,n)->new User(rs.getLong("id"),rs.getString("name"),rs.getString("email"),rs.getString("role")),email,password,role);return x.stream().findFirst();}
 public User create(String name,String email,String password,String role){jdbc.update("INSERT INTO users(name,email,password,role) VALUES(?,?,?,?)",name,email,password,role);return findByEmail(email).orElseThrow();}
 public int count(){return jdbc.queryForObject("SELECT COUNT(*) FROM users",Integer.class);}
}
