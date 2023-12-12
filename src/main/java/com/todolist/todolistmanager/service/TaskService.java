package com.todolist.todolistmanager.service;

import java.util.List;

import com.todolist.todolistmanager.pojo.Task;

public interface TaskService {
    void createTask(Task task);
    void deleteTask(Task task);
    Task findTaskById(Integer id);
    List<Task> getTasks();
}
