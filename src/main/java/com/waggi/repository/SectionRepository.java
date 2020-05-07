package com.waggi.repository;

import com.waggi.model.Section;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SectionRepository extends JpaRepository<Section, UUID> {
  List<Section> findAllByParentId(UUID parentId);
}
