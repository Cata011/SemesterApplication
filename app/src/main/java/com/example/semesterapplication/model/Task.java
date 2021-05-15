package com.example.semesterapplication.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "task_table")
public class Task implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String content;
    private boolean finished;

    public Task(String content, boolean finished) {
       this.content = content;
       this.finished = finished;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }
}
