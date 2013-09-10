package com.teachMng.onlineTeach.service;

import java.util.List;

import com.teachMng.onlineTeach.model.SchoolClass;
import com.teachMng.onlineTeach.model.Student;

public interface ISchoolClassService {
	List<SchoolClass> allSchoolClass();
	SchoolClass findById(int scID);
	boolean updSchoolClass(SchoolClass sc);
	List<Student> getStudents(int scId);
}
