package com.todolist.todolistmanager.service;

import java.util.List;

import com.todolist.todolistmanager.pojo.User;

public interface UserService {
    List<User> getUsers();
    void createUser(User user);
    User findUserById(int id);
}
