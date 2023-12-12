package com.todolist.todolistmanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todolist.todolistmanager.pojo.User;
import com.todolist.todolistmanager.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepo;

    @Override
    public List<User> getUsers() {
        return (List<User>) userRepo.findAll();
    }

    @Override
    public void createUser(User user) {
        userRepo.save(user);
    }

    @Override
    public User findUserById(int id) {
        return userRepo.findById(id).get();
    }
}
