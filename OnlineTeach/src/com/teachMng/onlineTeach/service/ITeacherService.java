package com.teachMng.onlineTeach.service;

import java.util.List;

import com.teachMng.onlineTeach.model.Teacher;

public interface ITeacherService {
	List<Teacher> allTeacher();
	Teacher findById(int tID);
	boolean updTeacher(Teacher teacher);
}
