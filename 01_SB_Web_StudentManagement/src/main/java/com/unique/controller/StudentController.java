package com.unique.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.unique.binding.Student;
import com.unique.service.impl.StudentServiceImpl;

@Controller
public class StudentController {

	// object will be included using autowire
	@Autowired
	private StudentServiceImpl stuImpl;

	@RequestMapping(value ={"/","/loadForm"})

	// mode carries data to view componet (student)
	public String loadForm(Model model) {
		// carry data to view component
		Student student = new Student();
		model.addAttribute("student", student);
		return "student";
	}

	@RequestMapping("/register")
	// captire the data from @model attribute
	public String handleform(@ModelAttribute("student") Student student, Model model) {
		// data store into the data base /
		// pass student object to service layer
		boolean saveStudent = stuImpl.saveStudent(student);
		String msg = "";

		if (saveStudent) {
			msg = "Student registaration sucessfully";
		} else
			msg = "Student Registaration Failed";
		// carry the msg to student,jsp(view component
		model.addAttribute("msg", msg);
		return "student";
	}
	
	@RequestMapping("/viewForm")
	public String viewAllRecords(Model model)
	{
		
		//interact service layer and get the data from the database
		//carrying dat ato view components , studtent information to front end
		List<Student> allStudents = stuImpl.getAllStudents();
		// we are carrying object to view
		model.addAttribute("allStudents",allStudents);
		
		
		
		
		return "view";
	}
	
	
	
	@RequestMapping("/deletestu")
	public String deleteStu(@RequestParam("id")  int sno)
	{
		
		stuImpl.deleteStudent(sno);
		
		return "redirect:/viewForm";
		
	}
	
	@RequestMapping("/editstu")
	public String editSave(@RequestParam("id") int sno, Model model)
	{
		
		//to fetch the data/ once we fetch display in edit
		//get the data from database 
		
		
		Student student = stuImpl.getEmpById(sno);
		model.addAttribute("student",student);
		return "editStudent";
	}
	
	@RequestMapping("/editSave")
	public String updateForm(@ModelAttribute Student student)
	{
		stuImpl.saveStudent(student);
		return"redirect:/viewForm";
	}
}
