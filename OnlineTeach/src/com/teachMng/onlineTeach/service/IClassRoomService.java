package com.teachMng.onlineTeach.service;

import java.util.List;

import com.teachMng.onlineTeach.model.ClassRoom;

public interface IClassRoomService {
	List<ClassRoom> allClassRoom();
	ClassRoom findById(int crID);
	boolean updClassRoom(ClassRoom cr);
}
