package com.darkside.studentsmanagement.students;

import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Student {
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue (
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String university;
    private LocalDate dateOfBirth;

    public Student() {
    }

    public Student(Long id, String firstName, String lastName, String email,
                   String university, LocalDate dateOfBirth) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.university = university;
        this.dateOfBirth = dateOfBirth;
    }

    public Student(String firstName, String lastName, String email, String university, LocalDate dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.university = university;
        this.dateOfBirth = dateOfBirth;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String cycle) {
        this.email = cycle;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String specialization) {
        this.university = specialization;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", university='" + university + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}
