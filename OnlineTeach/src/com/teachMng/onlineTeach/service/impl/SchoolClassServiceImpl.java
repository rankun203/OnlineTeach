package com.teachMng.onlineTeach.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.teachMng.onlineTeach.dao.ISchoolClassDAO;
import com.teachMng.onlineTeach.model.SchoolClass;
import com.teachMng.onlineTeach.model.Student;
import com.teachMng.onlineTeach.service.ISchoolClassService;
@Component("schoolClassService")
public class SchoolClassServiceImpl implements ISchoolClassService {
	private ISchoolClassDAO schoolClassDao;
	public ISchoolClassDAO getSchoolClassDao() {
		return schoolClassDao;
	}
	@Resource(name="schoolClassDao")
	public void setSchoolClassDao(ISchoolClassDAO schoolClassDao) {
		this.schoolClassDao = schoolClassDao;
	}

	@Override
	@Transactional
	public List<SchoolClass> allSchoolClass() {
		return schoolClassDao.allSchoolClass();
	}

	@Override
	@Transactional
	public SchoolClass findById(int scID) {
		return schoolClassDao.findById(scID);
	}

	@Override
	@Transactional
	public boolean updSchoolClass(SchoolClass sc) {
		return schoolClassDao.updSchoolClass(sc);
	}
	@Override
	@Transactional
	public List<Student> getStudents(int scId) {
		return schoolClassDao.getStudents(scId);
	}

}
