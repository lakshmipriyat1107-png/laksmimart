package com.priyamart.priyamart.model;
import java.math.BigDecimal;
public record CartItem(Long id,Long userId,Long productId,String name,BigDecimal price) {}
