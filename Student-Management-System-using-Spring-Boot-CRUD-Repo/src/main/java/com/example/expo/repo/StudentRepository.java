package com.example.expo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.expo.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>,CrudRepository<Student, Integer>{

}
