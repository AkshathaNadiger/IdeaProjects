package com.example.expo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.expo.model.Student;
import com.example.expo.service.ServiceI;

@RestController
public class StudentController {

	@Autowired
	private ServiceI si;

	@PostMapping("/save")
	public String addStudent(@RequestBody Student student) {
		si.addStudent(student);
		return "Student added successfully";
	}

	@PostMapping("/saveAll")
	public String addStudents(@RequestBody List<Student> students) {
		si.addStudents(students);
		return "Students added successfully";
	}

	@GetMapping("/getbyid/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable int id) {
		Student student = si.getStudentById(id);
		if (student != null) {
			return ResponseEntity.ok(student);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}

	@GetMapping("/getall")
	public List<Student> getAllStudents() {
		return si.getAllStudents();
	}
	@GetMapping("/listByIds/{ids}")
    public List<Student> getAllStudentsById(@PathVariable List<Integer> ids) {
        return si.getAllStudentsById(ids);
    }

	@PutMapping("update/{id}")
	public String updateStudent(@PathVariable int id, @RequestBody Student student) {
			si.updateStudent(id, student);
			return "Student updated successfully";
	}

	@DeleteMapping("deletebyid/{id}")
	public String deleteStudentById(@PathVariable int id) {
		si.deleteStudentById(id);
		return "Student deleted successfully";

	}

	@DeleteMapping("/deleteall")
	public String deleteAllStudents() {
		si.deleteAllStudents();
		return "All students deleted successfully";
	}

	@DeleteMapping("/bulkdelete/{ids}")
	public String deleteStudentsById(@PathVariable List<Integer> ids) {
		si.deleteAllStudentsById(ids);
		return "Students with IDs " + ids + " deleted successfully";
	}

	@GetMapping("/count")
	public long countStudents() {
		return si.countStudents();
	}

	@GetMapping("/exists/{id}")
	public boolean isStudentExists(@PathVariable int id) {
		return si.isStudentExists(id);
	}

}