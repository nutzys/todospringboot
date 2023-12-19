package com.todolist.todolistmanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todolist.todolistmanager.pojo.Task;
import com.todolist.todolistmanager.repository.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService{
    @Autowired
    TaskRepository taskRepo;

    @Override
    public void createTask(Task task) {
        taskRepo.save(task);
    }

    @Override
    public void deleteTask(Integer id) {
        Task task = taskRepo.findById(id).get();
        taskRepo.delete(task);
    }

    @Override
    public List<Task> getTasks() {
        return (List<Task>) taskRepo.findAll();
    }

    @Override
    public Task findTaskById(Integer id) {
        return taskRepo.findById(id).get();
    }
}
