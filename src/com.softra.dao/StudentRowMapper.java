package com.softra.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.softra.dto.Student;

public class StudentRowMapper implements RowMapper<Student> {

	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		String name = rs.getString("name");
		int age = rs.getInt("age");
		String mobile = rs.getString("mobile");
		String address = rs.getString("address");
		
		Student e = new Student(name, age, mobile, address);
		return e;
	}

}
