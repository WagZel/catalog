package com.waggi.repository;

import com.waggi.model.Product;
import com.waggi.repository.model.ProductFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CriteriaProductRepository {
  Page<Product> findAllByFilterParams(ProductFilter productFilter, Pageable pageable);
}
