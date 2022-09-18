package com.unique.service;

import java.util.List;

import com.unique.binding.Student;

public interface StudentService {

	// to store the data in the data base 
	public boolean saveStudent(Student st);

	//to fetch data form the data base
	public List<Student> getAllStudents();

	public Student getEmpById(int id);

	public boolean updateStudent(Student st);

	public void deleteStudent(int id);

}
