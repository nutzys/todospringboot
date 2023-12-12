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

import com.todolist.todolistmanager.pojo.Project;
import com.todolist.todolistmanager.service.ProjectService;

@RestController
@RequestMapping("/api/project")
public class ProjectController {
    @Autowired
    ProjectService projectService;

    @GetMapping("/projects")
    public ResponseEntity<List<Project>> getProjects(){
        return new ResponseEntity<>(projectService.getProjects(), HttpStatus.OK);
    }

    @GetMapping("/projects/{id}")
    public ResponseEntity<Project> getProject(@PathVariable Integer id){
        return new ResponseEntity<>(projectService.findProjectById(id), HttpStatus.OK);
    }

    @PostMapping("/projects/create")
    public ResponseEntity<HttpStatus> createProject(@RequestBody Project project){
        projectService.createProject(project);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/projects/delete")
    public ResponseEntity<HttpStatus> deleteProject(@RequestBody Project project){
        projectService.deleteProject(project);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
