package com.softra.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.softra.dao.IDao;
import com.softra.dto.Student;

public class StudentService implements IService {
	@Autowired
	private IDao dao;
	
	@Autowired
	private PlatformTransactionManager transactionManager;
	
	public StudentService() {
		
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void saveStudent(List<Student> list) {
		for( Student student : list) {
			dao.saveStudent(student);
		}

	}

	public void modifyStudent(List<Student> list) {
		for (Student stu : list) {
			dao.modifyStudent(stu);
		}

	}

}
