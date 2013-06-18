package com.teachMng.onlineTeach.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.teachMng.onlineTeach.dao.ITeacherDAO;
import com.teachMng.onlineTeach.model.Teacher;
import com.teachMng.onlineTeach.service.ITeacherService;
@Component("teacherService")
public class TeacherServiceImpl implements ITeacherService {
	private ITeacherDAO teacherDao;
	public ITeacherDAO getTeacherDao() {
		return teacherDao;
	}
	@Resource(name="teacherDao")
	public void setTeacherDao(ITeacherDAO teacherDao) {
		this.teacherDao = teacherDao;
	}

	@Override
	@Transactional
	public List<Teacher> allTeacher() {
		// TODO Auto-generated method stub
		return teacherDao.allTeacher();
	}

	@Override
	@Transactional
	public Teacher findById(int tID) {
		return teacherDao.findById(tID);
	}

	@Override
	@Transactional
	public boolean updTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		return teacherDao.updTeacher(teacher);
	}

}
