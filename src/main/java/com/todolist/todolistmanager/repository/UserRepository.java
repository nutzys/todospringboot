package com.todolist.todolistmanager.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.todolist.todolistmanager.pojo.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>
{
    
}
