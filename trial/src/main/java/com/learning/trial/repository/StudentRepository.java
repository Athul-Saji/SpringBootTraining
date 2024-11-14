package com.learning.trial.repository;

import com.learning.trial.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByCollegeNameOrderByNameDesc(String collegeName);
}
