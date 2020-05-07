package com.waggi.model;

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
    name = "section",
    indexes = {@Index(name = "idx_section_parent_id_1", columnList = "parent_id")})
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Section {

  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
  @Type(type = "org.hibernate.type.PostgresUUIDType")
  @Column(nullable = false, unique = true)
  private UUID id;

  @Column(unique = true, nullable = false)
  private String name;

  @Column(name = "parent_id")
  private UUID parentId;

  @CreationTimestamp private Date timestamp;
}
