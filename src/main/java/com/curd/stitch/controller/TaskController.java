package com.curd.stitch.controller;

import com.curd.stitch.entity.Person;
import com.curd.stitch.entity.Task;
import com.curd.stitch.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {
        List<Task> tasks = taskService.getAllTasks();
        return ResponseEntity.ok(tasks);
    }

    @PostMapping
    public ResponseEntity<Task> addTask(@RequestBody Task task) {
        Task addedTask = taskService.addTask(task);
        return ResponseEntity.ok(addedTask);
    }

    @PutMapping("/allocate/{id}")
    public ResponseEntity<Task> allocateTask(
            @PathVariable Long id,
            @RequestBody Person person
    ) {
        Task allocatedTask = taskService.allocateTask(id, person);

        if (allocatedTask == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(allocatedTask);
    }

    @PutMapping("/finalize/{id}")
    public ResponseEntity<Task> finishTask(@PathVariable Long id) {
        Task finishedTask = taskService.finishTask(id);

        if (finishedTask == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(finishedTask);
    }

    @GetMapping("/pending")
    public ResponseEntity<List<Task>> getOldestUnallocatedTasks(@RequestParam(defaultValue = "3") int limit) {
        List<Task> tasks = taskService.getOldestUnallocatedTasks(limit);
        return ResponseEntity.ok(tasks);
    }
}
