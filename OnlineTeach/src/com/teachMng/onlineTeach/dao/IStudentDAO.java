package com.teachMng.onlineTeach.dao;

import java.util.List;

import com.teachMng.onlineTeach.model.Student;

public interface IStudentDAO {
	List<Student> allStudent();
	Student findById(int sID);
	Student login(int stuId, String password);
	boolean logout(String stuId);
	boolean updStudent(Student stu);
}
