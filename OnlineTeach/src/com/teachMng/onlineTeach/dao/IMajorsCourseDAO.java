package com.teachMng.onlineTeach.dao;

import java.util.List;

import com.teachMng.onlineTeach.model.Course;
import com.teachMng.onlineTeach.model.Major;
import com.teachMng.onlineTeach.model.MajorsCourse;

public interface IMajorsCourseDAO {
	List<MajorsCourse> allMajorsCourse();
	List<MajorsCourse> getByMajorId(int majorID);
	List<MajorsCourse> getByCourseId(int courseID);
	List<MajorsCourse> getById(int majorID, int courseID);
}
