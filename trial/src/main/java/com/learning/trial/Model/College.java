package com.learning.trial.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.persistence.Id;
import java.util.List;

@Entity
public class College {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long collegeId;

    private String name;

    @OneToMany(mappedBy = "college", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Student> students;

   //  Constructors, Getters, and Setters

    public College() {}

    public College(String name) {
        this.name = name;
    }

    public Long getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(Long collegeId) {
        this.collegeId = collegeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }
}
