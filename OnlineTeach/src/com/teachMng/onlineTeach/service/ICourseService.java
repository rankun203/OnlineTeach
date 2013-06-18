package com.teachMng.onlineTeach.service;

import java.util.List;

import com.teachMng.onlineTeach.model.Course;

public interface ICourseService {
	List<Course> allCourse();
	Course findById(int cID);
	boolean updCourse(Course course);
}
