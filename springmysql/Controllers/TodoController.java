package com.example.springmysql.Controllers;

import com.example.springmysql.Models.Todo;
import com.example.springmysql.Service.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }


    @GetMapping("/todo")
    public String mainPage() {
        return "todolist";
    }


    //shows every task on the list
    @GetMapping({"/", "/list"})
    public String list(Model model) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        model.addAttribute("todos", todoService.listAll());
        model.addAttribute("creationTime", LocalDateTime.now().format(formatter));
        return "todolist";
    }

    @PostMapping({"/", "/list"})
    public String listPost(@RequestParam String input, Model model) {
        model.addAttribute("todos", todoService.search(input));
        return "todolist";
    }


    //shows list of tasks that are not finished yet
    @GetMapping("/list/active")
    public String isActive(Model model) {
        model.addAttribute("todos", todoService.findActive());
        return "todolist";
    }

    @GetMapping("/add")
    public String getTask() {
        return "addTask";
    }

    @PostMapping("/add")
    public String postTask(@RequestParam String title) {
        todoService.addTask(new Todo(title, true, false));
        return "redirect:/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable long id) {
        todoService.delete(id);
        return "redirect:/list";
    }

    @GetMapping("/edit/{id}")
    public String editGet(@PathVariable String id) {
        return "edit";
    }

    @PostMapping("/edit/{id}")
    public String editPost(@PathVariable long id, @RequestParam String title, boolean urgent, boolean done) {
        todoService.editItem(id, title, urgent, done);
        return "redirect:/list";
    }
}

