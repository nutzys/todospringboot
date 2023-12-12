package com.todolist.todolistmanager.repository;

import org.springframework.data.repository.CrudRepository;

import com.todolist.todolistmanager.pojo.Project;

public interface ProjectRepository extends CrudRepository<Project, Integer>{
    
}
