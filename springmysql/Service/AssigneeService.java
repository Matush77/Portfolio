package com.example.springmysql.Service;

import com.example.springmysql.Models.Assignee;
import com.example.springmysql.Models.Todo;
import com.example.springmysql.Repository.AssigneeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AssigneeService {

    AssigneeRepository assigneeRepository;

    public AssigneeService(AssigneeRepository assigneeRepository) {
        this.assigneeRepository = assigneeRepository;
    }

    public List<Assignee> listAll() {
        return assigneeRepository.findAll();
    }

    public void addTodo(Assignee assignee, Todo todo) {
        List<Todo> todoList = new ArrayList<>();
        todoList.add(todo);
    }
}
