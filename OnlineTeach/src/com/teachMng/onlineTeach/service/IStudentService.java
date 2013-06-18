package com.teachMng.onlineTeach.service;

import java.util.List;

import com.teachMng.onlineTeach.model.Student;

public interface IStudentService {
	List<Student> allStudent();
	Student findById(int sID);
	boolean updStudent(Student stu);
}
