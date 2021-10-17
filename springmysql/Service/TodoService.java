package com.example.springmysql.Service;

import com.example.springmysql.Models.Todo;
import com.example.springmysql.Repository.TodoRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Getter
@Setter
public class TodoService {

    TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public void addTask(Todo todo) {
        todoRepository.save(todo);
    }

    public List<Todo> listAll() {
        return todoRepository.findAll();
    }

    public List<Todo> findActive() {
       return todoRepository.findAll().stream()
               .filter(x -> !x.isDone()).collect(Collectors.toList());
    }

    public void delete(long id) {
        todoRepository.delete(todoRepository.getById(id));
    }


    public void editItem(long id, String title, boolean isUrgent, boolean isDone) {
        Todo todo = new Todo();
        todo.setTitle(title);
        todo.setUrgent(isUrgent);
        todo.setDone(isDone);
        todo.setId(id);
        todoRepository.save(todo);
    }


    public List<Todo> search(String input) {
        return todoRepository.findAll().stream()
                .filter(x -> x.getTitle().toLowerCase().contains(input))
                .collect(Collectors.toList());
    }

}
