package com.todolist.todolistmanager.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todolist.todolistmanager.pojo.Task;
import com.todolist.todolistmanager.service.TaskService;

@RestController
@RequestMapping("/api")
public class TaskController {
    @Autowired
    TaskService taskService;

    @GetMapping("/tasks")
    public ResponseEntity<List<Task>> getTasks(){
        return new ResponseEntity<>(taskService.getTasks(), HttpStatus.OK);
    }

    @GetMapping("/tasks/{id}")
    public ResponseEntity<Task> getTask(@PathVariable Integer id){
        return new ResponseEntity<>(taskService.findTaskById(id), HttpStatus.OK);
    }

    @PostMapping("/tasks/create")
    public ResponseEntity<HttpStatus> createTask(@RequestBody Task task){
        taskService.createTask(task);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/tasks/delete/{id}")
    public ResponseEntity<HttpStatus> deleteTask(@PathVariable Integer id){
        taskService.deleteTask(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
