package com.teachMng.onlineTeach.service;

import java.util.List;

import com.teachMng.onlineTeach.model.CoursePlanItem;

public interface ICoursePlanItemService {
	boolean insCoursePlanItem(CoursePlanItem cpi);
	void deleteAll();
	List<CoursePlanItem> allCoursePlan();
	List<CoursePlanItem> allCoursePlanByClassId(int classID);
	List<CoursePlanItem> allCoursePlanByTeacherId(int teacherID);
	List<CoursePlanItem> allCoursePlanByRoomId(int roomID);
	boolean updCoursePlan(CoursePlanItem cpi);
}
