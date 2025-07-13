package com.example.employeemultidb.model;

import jakarta.persistence.*;

@Entity
public class Employee {
    @Id @GeneratedValue
    private Long id;
    private String name;
    private String department;
    // Getters and setters
}
