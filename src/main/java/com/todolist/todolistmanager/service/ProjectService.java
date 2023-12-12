package com.todolist.todolistmanager.service;

import java.util.List;

import com.todolist.todolistmanager.pojo.Project;

public interface ProjectService {
    void createProject(Project project);
    void deleteProject(Project project);
    Project findProjectById(int id);
    List<Project> getProjects();
}
