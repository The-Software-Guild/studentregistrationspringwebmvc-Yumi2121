package com.softra.dao;

import java.util.List;

import com.softra.dto.Student;

public interface IDao {
	void saveStudent(Student student);
	void modifyStudent(Student student);
	public List<Student> getAllStudents();
	
	public Student getStudentbyName(String name);
	int getStudenCount();

}
