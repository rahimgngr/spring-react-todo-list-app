package com.rahimgng.springtodo.service;


import com.rahimgng.springtodo.entity.TodoHeadEntity;
import com.rahimgng.springtodo.entity.TodoSubEntity;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface TodoService {
 Object saveHead(TodoHeadEntity todoHeadEntity);
 Object saveIt(TodoSubEntity todoSubEntity);

 List<TodoHeadEntity> getAll();
 Optional<TodoHeadEntity> getSpes(Long id);

 void delete(Long id);
 void deleteAll();

 TodoSubEntity updateIt(TodoSubEntity todoSubEntity, Long taskId) throws IOException;
 void deleteIt(Long taskId);

}
