package com.rahimgng.springtodo.repository;

import com.rahimgng.springtodo.entity.TodoSubEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoSubRepo extends JpaRepository<TodoSubEntity, Long> {
}
