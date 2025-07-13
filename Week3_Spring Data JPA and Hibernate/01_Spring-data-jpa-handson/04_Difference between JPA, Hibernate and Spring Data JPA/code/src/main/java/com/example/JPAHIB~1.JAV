package com.example;

import com.example.hibernate.HibernateSave;
import com.example.model.Employee;
import com.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaHibernateComparisonApplication implements CommandLineRunner {

    @Autowired
    private EmployeeService service;

    public static void main(String[] args) {
        SpringApplication.run(JpaHibernateComparisonApplication.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.println("Spring Data JPA Saving...");
        service.addEmployee(new Employee("John", "HR"));

        System.out.println("Hibernate Saving...");
        HibernateSave.addEmployee();
    }
}
