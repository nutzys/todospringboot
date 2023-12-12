package com.todolist.todolistmanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todolist.todolistmanager.pojo.Project;
import com.todolist.todolistmanager.repository.ProjectRepository;

@Service
public class ProjectServiceImpl implements ProjectService{
    @Autowired
    ProjectRepository projectRepo;

    @Override
    public void createProject(Project project) {
        projectRepo.save(project);        
    }

    @Override
    public void deleteProject(Project project) {
        projectRepo.delete(project);        
    }

    @Override
    public Project findProjectById(int id) {
        return projectRepo.findById(id).get();
    }

    @Override
    public List<Project> getProjects() {
        return (List<Project>) projectRepo.findAll();
    }
}
