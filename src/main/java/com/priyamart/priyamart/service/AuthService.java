package com.priyamart.priyamart.service;
import com.priyamart.priyamart.model.User; import com.priyamart.priyamart.repository.UserRepository; import org.springframework.stereotype.Service;
@Service public class AuthService {
 private final UserRepository users; public AuthService(UserRepository users){this.users=users;}
 public User register(String name,String email,String password,String role){if(users.findByEmail(email).isPresent())throw new IllegalArgumentException("Email is already registered.");String r=role==null?"BUYER":role.toUpperCase();if(!r.equals("BUYER")&&!r.equals("SELLER"))throw new IllegalArgumentException("Only Buyer or Seller registration is allowed.");return users.create(name,email,password,r);}
 public User login(String email,String password,String role){String r=role==null?"BUYER":role.toUpperCase();return users.findLogin(email,password,r).orElseThrow(()->new IllegalArgumentException("Invalid email, password, or role."));}
}
