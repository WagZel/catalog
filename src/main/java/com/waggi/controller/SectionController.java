package com.waggi.controller;

import static org.springframework.http.ResponseEntity.ok;

import com.waggi.model.Section;
import com.waggi.service.SectionService;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/section")
@RestController
@RequiredArgsConstructor
public class SectionController {

  private final SectionService sectionService;

  @GetMapping("/{id}")
  ResponseEntity<?> getSection(@PathVariable UUID id) {
    return ResponseEntity.of(sectionService.get(id));
  }

  @GetMapping
  ResponseEntity<?> getSections(@RequestParam UUID parentId) {
    return ok(sectionService.getAll(parentId));
  }

  @PostMapping
  ResponseEntity<?> saveSection(@RequestBody Section section) {
    return ok(sectionService.save(section));
  }

  @DeleteMapping("/{id}")
  void deleteSection(@PathVariable UUID id) {
    sectionService.remove(id);
  }
}
