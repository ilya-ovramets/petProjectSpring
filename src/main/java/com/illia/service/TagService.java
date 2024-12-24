package com.illia.service;


import com.illia.model.Tag;
import com.illia.model.Tag;
import com.illia.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.List;
import java.util.Optional;

@Service
public class TagService {
    @Autowired
    TagRepository tagRepository;

    public List<Tag> findAll(){return tagRepository.findAll();}

    public Optional<Tag> findById(Long id){return tagRepository.findById(id);}

    public Tag save(Tag tag){return tagRepository.save(tag);}

    public Tag update(Long id, Tag updateTag){
        return this.findById(id).map(existedTag -> {
            existedTag.setName(updateTag.getName());
            existedTag.setTasks(updateTag.getTasks());
            return tagRepository.save(existedTag);

        }).orElseThrow(() -> new ResolutionException("Tag not found with ID" + id));

    }

    public void deleteById(Long id){tagRepository.deleteById(id);}

}
