package com.softra.service;

import java.util.List;

import com.softra.dto.Student;

public interface IService {
	void saveStudent(List<Student> list);
	void modifyStudent(List<Student> list);
}
