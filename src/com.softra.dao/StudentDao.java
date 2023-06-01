package com.softra.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.softra.dto.Student;

public class StudentDao implements IDao {
	@Autowired
	private JdbcTemplate template;
	
	@Autowired
	private PlatformTransactionManager transactionManager;
	
	public StudentDao() {
		
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void saveStudent(Student student) {
		String sql = "INSERT INTO student VALUES (?, ?, ?, ?)";
		template.update(sql, student.getName(),student.getAge(), student.getMobile(), student.getAddress());

	}

	@Override
	public void modifyStudent(Student student) {
		String sql = "update student set age=? where name=?";
		template.update(sql, student.getName(), student.getAge());

	}

	@Override
	public List<Student> getAllStudents() {
		String sql ="select * from student";
		return template.query(sql, new StudentRowMapper());
	}

	@Override
	public Student getStudentbyName(String stuname) {
		String sql = "select * from student where name=?";
		
		return template.queryForObject(sql, new Object[]{stuname}, new StudentRowMapper());
	}

	@Override
	public int getStudenCount() {
		String sql = "select count(*) from student";
		return template.queryForObject(sql, Integer.class);
	}

}
