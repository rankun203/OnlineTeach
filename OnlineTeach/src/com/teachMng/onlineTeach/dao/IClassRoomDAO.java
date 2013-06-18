package com.teachMng.onlineTeach.dao;

import java.util.List;

import com.teachMng.onlineTeach.model.ClassRoom;

public interface IClassRoomDAO {
	List<ClassRoom> allClassRoom();
	ClassRoom findById(int crID);
	boolean updClassRoom(ClassRoom cr);
}
