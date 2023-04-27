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
@Table(name = "leave")
public class Leave {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String country;
    private String institution;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate leaveDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate returnDate;
    private String educationLevel;
    private int days;
    @ManyToOne
    @JoinColumn(name = "EmpID")
    private Employee employee;

}

