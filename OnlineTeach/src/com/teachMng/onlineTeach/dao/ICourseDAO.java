package com.teachMng.onlineTeach.dao;

import java.util.List;

import com.teachMng.onlineTeach.model.Course;

public interface ICourseDAO {
	List<Course> allCourse();
	Course findById(int cID);
	boolean updCourse(Course course);
}
