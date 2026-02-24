package com.example.expo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.expo.model.Student;
import com.example.expo.repo.StudentRepository;

@Service
public class ServiceIMPL implements ServiceI{

	@Autowired
	private StudentRepository studentrepository;

    @Override
    public void addStudent(Student student) {
        studentrepository.save(student);
    }

   

    @Override
    public Student getStudentById(int id) {
        return studentrepository.findById(id).orElse(null);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentrepository.findAll();
    }

    @Override
    public List<Student> getAllStudentsById(List<Integer> ids) {
        return studentrepository.findAllById(ids);
    }

    @Override
    public void updateStudent(int id, Student student) {
        if (studentrepository.existsById(id)) {
            student.setId(id);
            studentrepository.save(student);
        } else {
            throw new RuntimeException("Student not found with id: " + id);
        }
    }

    @Override
    public void deleteStudentById(int id) {
        studentrepository.deleteById(id);
    }

    @Override
    public void deleteAllStudents() {
        studentrepository.deleteAll();
    }

    @Override
    public void deleteAllStudentsById(List<Integer> ids) {
        List<Student> studentsToDelete = studentrepository.findAllById(ids);
        studentrepository.deleteAll(studentsToDelete);
    }

    @Override
    public long countStudents() {
        return studentrepository.count();
    }

    @Override
    public boolean isStudentExists(int id) {
        return studentrepository.existsById(id);
    }

	@Override
	public void addStudents(List<Student> students) {
		studentrepository.saveAll(students);
		
	}
	}
