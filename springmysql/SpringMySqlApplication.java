package com.example.springmysql;

import com.example.springmysql.Models.Assignee;
import com.example.springmysql.Models.Todo;
import com.example.springmysql.Repository.AssigneeRepository;
import com.example.springmysql.Repository.TodoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringMySqlApplication implements CommandLineRunner {

    TodoRepository todoRepository;
    AssigneeRepository assigneeRepository;

    public SpringMySqlApplication(TodoRepository todoRepository, AssigneeRepository assigneeRepository) {
        this.todoRepository = todoRepository;
        this.assigneeRepository = assigneeRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringMySqlApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
            todoRepository.save(new Todo("I have to learn Object Relational Mapping", true, true));
            todoRepository.save(new Todo("I have to learn Java programming", false, true));
            todoRepository.save(new Todo("I have to learn RESTful apps", true, false));
            todoRepository.save(new Todo("I have to learn Thymeleaf", false, false));

            assigneeRepository.save(new Assignee("Matus", "hricikmatus@gmail.com"));
    }
}
