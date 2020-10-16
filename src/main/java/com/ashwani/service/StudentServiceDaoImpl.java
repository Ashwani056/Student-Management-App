package com.ashwani.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashwani.dao.StudentDao;
import com.ashwani.entity.Student;

@Service
public class StudentServiceDaoImpl implements StudentService {

	@Autowired
	StudentDao StudentDao;
	
	@Override
	public String addStudent(Student student) {
		String status=StudentDao.add(student);
		return status;
	}

	@Override
	public Student searchStudent(String sid) {
		
		Student student = StudentDao.search(sid);
		return student;
	}

	@Override
	public String updateStudent(Student student) {
		String status = StudentDao.update(student);
		return status;
	}

	@Override
	public String deleteStudent(String sid) {
		String status=StudentDao.delete(sid);
		return status;
	}

}
