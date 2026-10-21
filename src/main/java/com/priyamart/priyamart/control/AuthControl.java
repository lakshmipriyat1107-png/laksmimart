package com.priyamart.priyamart.control;
import com.priyamart.priyamart.model.User; import com.priyamart.priyamart.service.AuthService; import org.springframework.http.*; import org.springframework.web.bind.annotation.*; import java.util.Map;
@RestControl @RequestMapping("/api/auth") public class AuthControl {
 private final AuthService auth; public AuthControl(AuthService auth){this.auth;}
 @PostMapping("/register") public ResponseEntity<?> register(@RequestBody Map<String,String> b){try{User u=auth.register(b.get("name"),b.get("email"),b.get("password"),b.get("role"));return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("user",u));}catch(IllegalArgumentException e){return ResponseEntity.badRequest().body(Map.of("message",e.getMessage()));}}
 @PostMapping("/login") public ResponseEntity<?> login(@RequestBody Map<String,String> b){try{User u=auth.login(b.get("email"),b.get("password"),b.get("role"));return ResponseEntity.ok(Map.of("user",u));}catch(IllegalArgumentException e){return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("message",e.getMessage()));}}
}
