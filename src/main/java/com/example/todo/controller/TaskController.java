package com.example.todo.controller;

import com.example.todo.model.Task;
import com.example.todo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*") // フロントエンドとの接続許可
@RestController//JSON形式でレスポンスを返すController
@RequestMapping("/tasks")//APIのルートパスを指定（すべて/tasks配下）
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    // 一覧取得
    @GetMapping
    public List<Task> getTasks() {//タスク一覧取得
        return taskRepository.findAll();
    }

    // 新規作成
    @PostMapping
    public Task createTask(@RequestBody Task task) {//新しいタスクの作成
        return taskRepository.save(task);
    }

    // 更新
    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task updated) {//タスクの更新
        Task task = taskRepository.findById(id).orElseThrow();
        task.setTitle(updated.getTitle());
        task.setCompleted(updated.isCompleted());
        return taskRepository.save(task);
    }

    // 削除
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {//タスクの削除
        taskRepository.deleteById(id);
    }
}