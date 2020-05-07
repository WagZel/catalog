package com.playershealth.repository;

import com.playershealth.model.Product;
import com.playershealth.repository.model.ProductFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CriteriaProductRepository {
  Page<Product> findAllByFilterParams(ProductFilter productFilter, Pageable pageable);
}
