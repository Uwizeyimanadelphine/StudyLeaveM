package com.finalproject.urproject.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long emp_id;

    private String firstName;
    private String lastName;
    @ManyToOne
    @JoinColumn(name = "depId")
    private Department department;

    private String gender;
    private String email;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date_of_birth;
    private String role;


}
