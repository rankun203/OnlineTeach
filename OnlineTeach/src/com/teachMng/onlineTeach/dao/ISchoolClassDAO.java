package com.teachMng.onlineTeach.dao;

import java.util.List;

import com.teachMng.onlineTeach.model.SchoolClass;

public interface ISchoolClassDAO {
	List<SchoolClass> allSchoolClass();
	SchoolClass findById(int scID);
	boolean updSchoolClass(SchoolClass sc);
}
