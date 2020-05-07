package com.waggi.controller;

import static org.springframework.http.ResponseEntity.ok;

import com.waggi.model.Product;
import com.waggi.repository.model.ProductFilter;
import com.waggi.service.ProductService;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/product")
@RestController
@RequiredArgsConstructor
public class ProductController {

  private final ProductService productService;

  @GetMapping
  ResponseEntity<?> getProducts(
      @RequestParam(required = false) UUID sectionId,
      @RequestParam(required = false) String name,
      @RequestParam(required = false) Double minPrice,
      @RequestParam(required = false) Double maxPrice,
      Pageable pageable) {
    return ok(productService.getAll(new ProductFilter(sectionId, name, minPrice, maxPrice), pageable));
  }

  @GetMapping("/{id}")
  ResponseEntity<?> getProduct(@PathVariable UUID id) {
    return ResponseEntity.of(productService.get(id));
  }

  @PostMapping
  ResponseEntity<?> saveProduct(@RequestBody Product product) {
    return ok(productService.save(product));
  }

  @DeleteMapping("/{id}")
  void deleteProduct(@PathVariable UUID id) {
    productService.remove(id);
  }
}
