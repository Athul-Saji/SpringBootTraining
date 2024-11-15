package com.learning.trial.service;

import com.learning.trial.Model.College;
import com.learning.trial.Model.Student;
import com.learning.trial.repository.CollegeRepository;
import com.learning.trial.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CollegeService {

    @Autowired
    private CollegeRepository collegeRepository;

    @Autowired
    private StudentRepository studentRepository;

    public College createCollege(College college) {
        return collegeRepository.save(college);
    }

    @Transactional
    public Student createStudent(Long collegeId, Student student) {
        collegeRepository.
        College college = collegeRepository.findById(collegeId)
                .orElseThrow(() -> new IllegalArgumentException("College not found"));
        student.setCollege(college);
        return studentRepository.save(student);
    }

    public List<College> getAllColleges() {
        return collegeRepository.findAll();
    }

    public List<Student> getStudentsByCollegeName(String collegeName) {
        return studentRepository.findByCollegeNameOrderByNameDesc(collegeName);
    }
}
