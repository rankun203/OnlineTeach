package com.teachMng.onlineTeach.service;

import java.util.List;

import com.teachMng.onlineTeach.model.MajorsCourse;

public interface IMajorsCourseService {
	List<MajorsCourse> allMajorsCourse();
	List<MajorsCourse> getByMajorId(int majorID);
	List<MajorsCourse> getByCourseId(int courseID);
	List<MajorsCourse> getById(int majorID, int courseID);
}
