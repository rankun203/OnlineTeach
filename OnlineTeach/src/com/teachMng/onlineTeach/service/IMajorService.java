package com.teachMng.onlineTeach.service;

import java.util.List;

import com.teachMng.onlineTeach.model.Major;

public interface IMajorService {
	List<Major> allMajor();
	Major findById(int mID);
	boolean updMajor(Major major);
}
