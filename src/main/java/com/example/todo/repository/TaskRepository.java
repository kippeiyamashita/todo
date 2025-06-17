package com.example.todo.repository;

import com.example.todo.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
//JPAを使ったデータ操作用インターフェース
public interface TaskRepository extends JpaRepository<Task, Long> {//継承
}