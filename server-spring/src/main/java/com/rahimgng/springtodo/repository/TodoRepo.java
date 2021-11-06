package com.rahimgng.springtodo.repository;

import com.rahimgng.springtodo.entity.TodoHeadEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepo extends JpaRepository<TodoHeadEntity,Long > {

}
