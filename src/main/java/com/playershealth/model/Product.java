package com.playershealth.model;

import java.util.Date;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Table(
    name = "product",
    indexes = {@Index(name = "idx_product_section_id_1", columnList = "section_id")})
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
  @Type(type = "org.hibernate.type.PostgresUUIDType")
  @Column(nullable = false, unique = true)
  private UUID id;

  @Column(nullable = false)
  private String name;

  @Column private Double price;

  @Column(name = "section_id", nullable = false)
  private UUID sectionId;

  @CreationTimestamp private Date timestamp;
}
