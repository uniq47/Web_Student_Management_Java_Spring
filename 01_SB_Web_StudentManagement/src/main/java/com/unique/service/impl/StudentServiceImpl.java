package com.unique.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unique.binding.Student;
import com.unique.entity.StudentEntity;
import com.unique.repo.StudentRepository;
import com.unique.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository daoImpl;

	@Override
	public boolean saveStudent(Student st) {
		// TODO Auto-generated method stub
		// student object assigned to entity clas
		// entity class mapped with data base table

		StudentEntity entity = new StudentEntity();

		BeanUtils.copyProperties(st, entity);

		// store Entity Object inside the database
		StudentEntity stuEn = daoImpl.save(entity);
		boolean flag = false;
		if (stuEn != null)
			flag = true;

		return flag;
	}

	@Override
	public List<Student> getAllStudents() {
		
		//student class object to conver to student class 
		List<Student>addStudents= new ArrayList<>();
		List<StudentEntity> findAll = daoImpl.findAll(); // entity class object(find all) we getting adding in addStudents 
		
		for(StudentEntity se: findAll)
		{
			Student stu= new Student();
			// copy entity class data to Student class 
			BeanUtils.copyProperties(se, stu);
			addStudents.add(stu);
		}
		// TODO Auto-generated method stub
		return addStudents;
	}
 
	@Override
	public Student getEmpById(int id) {
		// TODO Auto-generated method stub
		Optional<StudentEntity> findById = daoImpl.findById(id);
		StudentEntity studentEntity = findById.get();
		//copy the data from Entity to binding class 
		Student student= new Student();
		BeanUtils.copyProperties(studentEntity, student);
		return student;
	}

	@Override
	public boolean updateStudent(Student st) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void deleteStudent(int id) {
		// TODO Auto-generated method stub

		daoImpl.deleteById(id);
		
		
	}

}
