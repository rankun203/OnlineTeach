package com.teachMng.onlineTeach.dao;

import java.util.List;

import com.teachMng.onlineTeach.model.MajorsCourse;

@SuppressWarnings("unused")
public interface IMajorsCourseDAO {
	List<MajorsCourse> allMajorsCourse();
	List<MajorsCourse> getByMajorId(int majorID);
	List<MajorsCourse> getByCourseId(int courseID);
	List<MajorsCourse> getById(int majorID, int courseID);
}
