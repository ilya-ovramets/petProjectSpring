package com.illia.controller;

import com.illia.dto.TagDTO;
import com.illia.mapper.TagMapper;
import com.illia.model.Tag;
import com.illia.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tag")
public class TagController {

    @Autowired
    TagService tagService;

    @Autowired
    TagMapper tagMapper;

    @GetMapping
    public List<TagDTO> findAll() {
        return tagService.findAll().stream().map(tagMapper::toDTO).toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TagDTO> findById(@PathVariable Long id) {
        return tagService.findById(id)
                .map(tag -> ResponseEntity.ok(tagMapper.toDTO(tag)))
                .orElse(ResponseEntity.notFound().build());
    }

    @ResponseStatus(HttpStatus.CREATED) // 201
    @PostMapping
    public ResponseEntity<TagDTO> create(@RequestBody TagDTO tagDTO) {
        Tag tag = tagMapper.toEntity(tagDTO);
        tagService.save(tag);
        return ResponseEntity.ok().body(tagDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TagDTO> update(@PathVariable Long id, @RequestBody TagDTO tagDTO) {
        Tag tag = tagMapper.toEntity(tagDTO);
        Tag updatedTag = tagService.update(id, tag);
        return ResponseEntity.ok(tagMapper.toDTO(updatedTag));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT) // 204
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        tagService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
