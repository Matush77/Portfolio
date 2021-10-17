package com.example.springmysql.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Getter
@Setter

@Entity
public class Assignee {

    @javax.persistence.Id
    private long Id;
    private String name;
    private String email;
    @ManyToOne
    @JoinColumn(name = "todo_id")
    private Todo todo;

    public Assignee(String name, String email) {
        this.name = name;
        this.email = email;

    }

    public Assignee() {

    }
}
