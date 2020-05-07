package com.playershealth.repository.impl;

import static java.util.Objects.nonNull;
import static java.util.stream.Collectors.toList;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

import com.playershealth.model.Product;
import com.playershealth.repository.CriteriaProductRepository;
import com.playershealth.repository.model.ProductFilter;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.criteria.Predicate;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CriteriaProductRepositoryImpl implements CriteriaProductRepository {

  private final EntityManager entityManager;

  public Page<Product> findAllByFilterParams(ProductFilter productFilter, Pageable pageable) {
    var builder = entityManager.getCriteriaBuilder();
    var query = builder.createQuery(Product.class);
    var root = query.from(Product.class);
    var predicates = new ArrayList<Predicate>();

    if (nonNull(productFilter.getSectionId())) {
      predicates.add(builder.equal(root.get("sectionId"), productFilter.getSectionId()));
    }

    if (isNotBlank(productFilter.getName())) {
      predicates.add(builder.like(builder.lower(root.get("name")), "%" + productFilter.getName().toLowerCase() + "%"));
    }

    if (nonNull(productFilter.getMinPrice())) {
      predicates.add(builder.greaterThanOrEqualTo(root.get("price"), productFilter.getMinPrice()));
    }

    if (nonNull(productFilter.getMaxPrice())) {
      predicates.add(builder.lessThanOrEqualTo(root.get("price"), productFilter.getMaxPrice()));
    }

    query.where(predicates.toArray(new Predicate[0]));
    query.orderBy(
        pageable.getSort().stream()
            .map(
                order -> {
                  var path = root.get(order.getProperty());
                  return order.isAscending() ? builder.asc(path) : builder.desc(path);
                })
            .collect(toList()));

    return new PageImpl<>(entityManager.createQuery(query).getResultList(), pageable, pageable.getOffset());
  }
}
