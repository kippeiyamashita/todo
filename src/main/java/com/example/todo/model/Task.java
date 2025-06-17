package com.example.todo.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data // Lombokを使用（使用しない場合はgetter/setterを自分で定義）
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;//主キー（自動で増えるID）

    @Column(nullable = false)
    private String title;//タスクのタイトル（必須）

    private boolean completed = false;//タスクが完了済みかどうか（初期値False）
}