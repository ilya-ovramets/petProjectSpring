package com.illia.repository;

import com.illia.model.Task;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {

    @EntityGraph(attributePaths = {"performers", "status", "tags"})
    Optional<Task> findById(Long id);

}
