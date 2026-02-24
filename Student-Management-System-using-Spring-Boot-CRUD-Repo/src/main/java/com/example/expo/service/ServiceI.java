package com.example.expo.service;

import java.util.List;

import com.example.expo.model.Student;

public interface ServiceI {

	void addStudent(Student student);

    void addStudents(List<Student> students);

    Student getStudentById(int id);

    List<Student> getAllStudents();

    List<Student> getAllStudentsById(List<Integer> ids);

    void deleteStudentById(int id);

    void deleteAllStudents();

    void deleteAllStudentsById(List<Integer> ids);

    long countStudents();

    boolean isStudentExists(int id);

	void updateStudent(int id, Student student);

}
