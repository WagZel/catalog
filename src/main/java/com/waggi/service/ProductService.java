package com.waggi.service;

import com.waggi.model.Product;
import com.waggi.repository.ProductRepository;
import com.waggi.repository.model.ProductFilter;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

  private final ProductRepository productRepository;

  public Optional<Product> get(UUID id) {
    return productRepository.findById(id);
  }

  public Page<Product> getAll(ProductFilter filter, Pageable pageable) {
    return productRepository.findAllByFilterParams(filter, pageable);
  }

  public Product save(Product product) {
    return productRepository.save(product);
  }

  public void remove(UUID productId) {
    productRepository.deleteById(productId);
  }

  public void removeAll(UUID sectionId) {
    productRepository.deleteAllBySectionId(sectionId);
  }
}
