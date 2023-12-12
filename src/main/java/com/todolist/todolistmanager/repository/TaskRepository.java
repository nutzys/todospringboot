package com.todolist.todolistmanager.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.todolist.todolistmanager.pojo.Task;

@Repository
public interface TaskRepository extends CrudRepository<Task, Integer>{
    
}
