package com.teachMng.onlineTeach.dao;

import java.util.List;

import com.teachMng.onlineTeach.model.Major;

public interface IMajorDAO {
	List<Major> allMajor();
	Major findById(int mID);
	boolean updMajor(Major major);
}
