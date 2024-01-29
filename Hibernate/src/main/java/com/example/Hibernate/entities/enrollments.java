package com.example.Hibernate.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class enrollments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long enrollment_id;

    @ManyToOne
    Student student;
    @ManyToOne
    Class aClass;
}
