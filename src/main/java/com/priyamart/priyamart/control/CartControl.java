package com.priyamart.priyamart.control;
import com.priyamart.priyamart.repository.*; import org.springframework.http.*; import org.springframework.web.bind.annotation.*; import java.util.Map;
@RestControl @RequestMapping("/api/cart") public class CartControl {
 private final CartRepository cart; private final ProductRepository products; public CartControl(CartRepository cart,ProductRepository products){this.cart=cart;this.products=products;}
 @GetMapping("/{userId}") public Object get(@PathVariable long userId){return cart.findByUser(userId);}
 @PostMapping public ResponseEntity<?> add(@RequestBody Map<String,Object> b){try{long u=Long.parseLong(String.valueOf(b.get("userId")));long p=Long.parseLong(String.valueOf(b.get("productId")));if(!products.exists(p))return ResponseEntity.badRequest().body(Map.of("message","Product not found."));cart.add(u,p);return ResponseEntity.ok(Map.of("message","Added to cart."));}catch(Exception e){return ResponseEntity.badRequest().body(Map.of("message","Invalid cart data."));}}
 @DeleteMapping("/{id}") public ResponseEntity<?> delete(@PathVariable long id){cart.delete(id);return ResponseEntity.noContent().build();}
}
