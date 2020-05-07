package com.waggi.service;

import com.waggi.model.Section;
import com.waggi.repository.SectionRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SectionService {

  private final ProductService productService;
  private final SectionRepository sectionRepository;

  public Optional<Section> get(UUID id) {
    return sectionRepository.findById(id);
  }

  public List<Section> getAll(UUID parentId) {
    return sectionRepository.findAllByParentId(parentId);
  }

  public Section save(Section section) {
    return sectionRepository.save(section);
  }

  public void remove(UUID id) {
    productService.removeAll(id);
    sectionRepository.deleteById(id);
  }
}
