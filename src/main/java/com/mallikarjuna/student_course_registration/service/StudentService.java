package com.mallikarjuna.student_course_registration.service;
import com.mallikarjuna.student_course_registration.exception.DuplicateEmailException;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mallikarjuna.student_course_registration.entity.Student;
import com.mallikarjuna.student_course_registration.exception.DuplicateEmailException;
import com.mallikarjuna.student_course_registration.repository.StudentRepository;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    // Constructor Injection (best practice)
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // Save a student
    public Student saveStudent(Student student) {
        if (studentRepository.existsByEmail(student.getEmail())) {
            throw new DuplicateEmailException("Email already registered");
        }
        return studentRepository.save(student);
    }


    // Get all students
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}
