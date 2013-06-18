package com.teachMng.onlineTeach.dao;

import java.util.List;

import com.teachMng.onlineTeach.model.Teacher;

public interface ITeacherDAO {
	List<Teacher> allTeacher();
	Teacher findById(int tID);
	boolean updTeacher(Teacher teacher);
}
