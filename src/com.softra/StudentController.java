package com.softra;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import com.softra.dto.Student;
import com.softra.service.IService;


@Controller
public class StudentController {
	
	@Autowired 
	IService service;
	
	@Autowired 
	@Qualifier(value="stuval")
	private Validator validator;

	@RequestMapping(value ="/stu.htm", method=RequestMethod.GET)
	public String showStuRegForm(Map<String, Student> map) {
		System.out.println("inside showEmpForm of EmployeeController");
		map.put("e", new Student());
		return "studentform";
	}
	
	@RequestMapping(value ="/stu.htm", method=RequestMethod.POST)
	public String persistStudent(@ModelAttribute("e") Student e, BindingResult result, Map<String, Student> map) {
		map.put("e", e);
		
		List<Student> list = new ArrayList<>();
		list.add(e);
		service.saveStudent(list);
		
		return "success";
	}
	
}
