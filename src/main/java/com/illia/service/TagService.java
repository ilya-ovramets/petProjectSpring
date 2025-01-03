package com.illia.service;


import com.illia.dto.TagDTO;
import com.illia.dto.TagDTO;
import com.illia.mapper.TagMapper;
import com.illia.model.Tag;
import com.illia.model.Tag;
import com.illia.model.Tag;
import com.illia.repository.TagRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.List;
import java.util.Optional;

@Service
public class TagService {
    @Autowired
    TagRepository tagRepository;

    @Autowired
    TagMapper tagMapper;

    @Transactional
    public List<TagDTO> findAll(){
        return tagRepository.findAll()
                .stream().map(tagMapper::toDtoLazy)
                .toList();
    }

    @Transactional
    public Optional<TagDTO> findById(Long id){
        return tagRepository.findById(id).map(tagMapper::toDtoEager);
    }


    public TagDTO save(TagDTO tagDTO){
        try {
            Tag tag = tagMapper.toEntityLazy(tagDTO);
            tagRepository.save(tag);
            return tagDTO;
        }catch (Exception ex){
            throw ex;
        }
    }

    @Transactional
    public TagDTO update(Long id, TagDTO tagDTO){
        try {
            Tag existingTag = tagRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("Tag with id " + id + " not found"));
            tagMapper.partialUpdate(existingTag,tagDTO);
            return tagDTO;
        }catch (Exception e){
            throw e;
        }
    }

    public void deleteById(Long id){tagRepository.deleteById(id);}

}
