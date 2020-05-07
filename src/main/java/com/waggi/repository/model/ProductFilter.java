package com.waggi.repository.model;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductFilter {
  private UUID sectionId;
  private String name;
  private Double minPrice;
  private Double maxPrice;
}
