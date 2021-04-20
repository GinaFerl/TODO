package com.gferl.todoapplication.model;

public class ToDo {
    String id_todo;
    String name_todo;
    String status_todo;

    public ToDo() {
    }

    public ToDo(String id_todo, String name_todo, String status_todo) {
        this.id_todo = id_todo;
        this.name_todo = name_todo;
        this.status_todo = status_todo;
    }

    public String getId_todo() {
        return id_todo;
    }

    public void setId_todo(String id_todo) {
        this.id_todo = id_todo;
    }

    public String getName_todo() {
        return name_todo;
    }

    public void setName_todo(String name_todo) {
        this.name_todo = name_todo;
    }

    public String getStatus_todo() {
        return status_todo;
    }

    public void setStatus_todo(String status_todo) {
        this.status_todo = status_todo;
    }
}
