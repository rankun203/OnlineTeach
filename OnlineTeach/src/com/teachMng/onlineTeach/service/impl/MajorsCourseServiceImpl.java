package com.teachMng.onlineTeach.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.teachMng.onlineTeach.dao.IMajorsCourseDAO;
import com.teachMng.onlineTeach.model.MajorsCourse;
import com.teachMng.onlineTeach.service.IMajorsCourseService;
@Component("majorsCourseService")
public class MajorsCourseServiceImpl implements IMajorsCourseService {
	private IMajorsCourseDAO majorsCourseDao;
	public IMajorsCourseDAO getMajorsCourseDao() {
		return majorsCourseDao;
	}
	@Resource(name="majorsCourseDao")
	public void setMajorsCourseDao(IMajorsCourseDAO majorsCourseDao) {
		this.majorsCourseDao = majorsCourseDao;
	}

	@Override
	@Transactional
	public List<MajorsCourse> allMajorsCourse() {
		return majorsCourseDao.allMajorsCourse();
	}

	@Override
	@Transactional
	public List<MajorsCourse> getByMajorId(int majorID) {
		return majorsCourseDao.getByMajorId(majorID);
	}

	@Override
	@Transactional
	public List<MajorsCourse> getByCourseId(int courseID) {
		return majorsCourseDao.getByCourseId(courseID);
	}

	@Override
	@Transactional
	public List<MajorsCourse> getById(int majorID, int courseID) {
		return majorsCourseDao.getById(majorID, courseID);
	}

}
