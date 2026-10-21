package com.priyamart.priyamart.control;
import com.priyamart.priyamart.model.Product; import com.priyamart.priyamart.repository.ProductRepository; import org.springframework.http.*; import org.springframework.web.bind.annotation.*; import java.math.BigDecimal; import java.util.Map;
@RestControl @RequestMapping("/api/products") public class ProductControl {
 private final ProductRepository products; public ProductControl(ProductRepository products){this.products=products;}
 @GetMapping public java.util.List<Product> all(){return products.findAll();}
 @PostMapping public ResponseEntity<?> create(@RequestBody Map<String,Object> b){try{Product p=new Product(null,String.valueOf(b.get("name")),String.valueOf(b.getOrDefault("description","")),new BigDecimal(String.valueOf(b.get("price"))),String.valueOf(b.getOrDefault("category","Other")),b.get("sellerId")==null?null:Long.valueOf(String.valueOf(b.get("sellerId"))));return ResponseEntity.status(HttpStatus.CREATED).body(products.create(p));}catch(Exception e){return ResponseEntity.badRequest().body(Map.of("message","Invalid product data."));}}
 @DeleteMapping("/{id}") public ResponseEntity<?> delete(@PathVariable long id){products.delete(id);return ResponseEntity.noContent().build();}
}
