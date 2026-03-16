package org.example.demo.Controller;

import lombok.RequiredArgsConstructor;
import org.example.demo.Entity.Todo;
import org.example.demo.Service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/todos")
public class ToDoController {
   // @Autowired
    private final TodoService todoService;
    @GetMapping
    public List<Todo> getTodos() {
        return todoService.findAll();
    }
    @GetMapping("/{id}")
    public Todo getTodo(@PathVariable Long id){
          return todoService.findById(id);
    }
   @PostMapping
    public Todo addTodo(@RequestBody Todo todo){
        return todoService.addTodo(todo);
   }
   @PutMapping("/{id}")
    public Todo updateTodo(@RequestBody Todo todo ,  @PathVariable Long id){
        return todoService.update(todo,id);
   }
   @DeleteMapping("/{id}")
    public Todo deleteTodo(@PathVariable Long id){
         return todoService.delete(id);
   }
}
