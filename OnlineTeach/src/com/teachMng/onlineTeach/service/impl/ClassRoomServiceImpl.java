package com.teachMng.onlineTeach.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.teachMng.onlineTeach.dao.IClassRoomDAO;
import com.teachMng.onlineTeach.model.ClassRoom;
import com.teachMng.onlineTeach.service.IClassRoomService;
@Component("classRoomService")
public class ClassRoomServiceImpl implements IClassRoomService {
	private IClassRoomDAO classRoomDao;

	public IClassRoomDAO getClassRoomDao() {
		return classRoomDao;
	}
	@Resource(name="classRoomDao")
	public void setClassRoomDao(IClassRoomDAO classRoomDao) {
		this.classRoomDao = classRoomDao;
	}

	@Override
	@Transactional
	public List<ClassRoom> allClassRoom() {
		return classRoomDao.allClassRoom();
	}

	@Override
	@Transactional
	public ClassRoom findById(int crID) {
		// TODO Auto-generated method stub
		return classRoomDao.findById(crID);
	}

	@Override
	@Transactional
	public boolean updClassRoom(ClassRoom cr) {
		// TODO Auto-generated method stub
		return classRoomDao.updClassRoom(cr);
	}

}
