package com.priyamart.priyamart.control;
import com.priyamart.priyamart.repository.*; import org.springframework.jdbc.core.JdbcTemplate; import org.springframework.web.bind.annotation.*; import java.util.Map;
@RestControl @RequestMapping("/api/admin") public class AdminControl {
 private final UserRepository users; private final ProductRepository products; private final JdbcTemplate jdbc;
 public AdminControl(UserRepository users,ProductRepository products,JdbcTemplate jdbc){this.users=users;this.products=products;this.jdbc=jdbc;}
 @GetMapping("/stats") public Map<String,Integer> stats(){Integer o=jdbc.queryForObject("SELECT COUNT(*) FROM orders",Integer.class);return Map.of("users",users.count(),"products",products.count(),"orders",o==null?0:o);}
}
