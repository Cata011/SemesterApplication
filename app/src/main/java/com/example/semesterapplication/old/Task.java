package com.example.semesterapplication.old;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "task_table")
public class Task {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String PLACEHOLDER_SOMESTUFF;
    private String PLACEHOLDER_SOMEOTHERSTUFF;

    public Task(String PLACEHOLDER_SOMESTUFF, String PLACEHOLDER_SOMEOTHERSTUFF) {
        this.PLACEHOLDER_SOMESTUFF = PLACEHOLDER_SOMESTUFF;
        this.PLACEHOLDER_SOMEOTHERSTUFF = PLACEHOLDER_SOMEOTHERSTUFF;
    }

    public String getPLACEHOLDER_SOMESTUFF() {
        return PLACEHOLDER_SOMESTUFF;
    }

    public String getPLACEHOLDER_SOMEOTHERSTUFF() {
        return PLACEHOLDER_SOMEOTHERSTUFF;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPLACEHOLDER_SOMESTUFF(String PLACEHOLDER_SOMESTUFF) {
        this.PLACEHOLDER_SOMESTUFF = PLACEHOLDER_SOMESTUFF;
    }

    public void setPLACEHOLDER_SOMEOTHERSTUFF(String PLACEHOLDER_SOMEOTHERSTUFF) {
        this.PLACEHOLDER_SOMEOTHERSTUFF = PLACEHOLDER_SOMEOTHERSTUFF;
    }
}
