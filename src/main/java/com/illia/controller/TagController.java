package com.illia.controller;


import com.illia.model.Tag;
import com.illia.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tag")
public class TagController {
    @Autowired
    TagService tagService;


    @GetMapping
    public List<Tag> findAll(){return tagService.findAll();}

    @GetMapping("/{id}")
    public Optional<Tag> findById(@PathVariable Long id){return tagService.findById(id);}

    @ResponseStatus(HttpStatus.CREATED) // 201
    @PostMapping
    public Tag create(@RequestBody Tag tag) {
        return tagService.save(tag);
    }

    @PutMapping
    public Tag update(@RequestBody Tag tag) {
        return tagService.save(tag);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT) // 204
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        tagService.deleteById(id);
    }
}
