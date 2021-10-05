package com.example.project.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    private String title;

    @NotNull
    private String content;

    @NotNull
    private String startTime;

    @NotNull
    private String endTime;

    @NotNull
    private String policy;

    public Product() {
    }

    public Product(int id, String title, String content, String startTime, String endTime, String policy) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.startTime = startTime;
        this.endTime = endTime;
        this.policy = policy;
    }

}
