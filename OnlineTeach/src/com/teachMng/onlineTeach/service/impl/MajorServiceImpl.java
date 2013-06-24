package com.teachMng.onlineTeach.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.teachMng.onlineTeach.dao.IMajorDAO;
import com.teachMng.onlineTeach.model.Major;
import com.teachMng.onlineTeach.service.IMajorService;
@Component("majorService")
public class MajorServiceImpl implements IMajorService {
	private IMajorDAO majorDao;

	public IMajorDAO getMajorDao() {
		return majorDao;
	}
	@Resource(name="majorDao")
	public void setMajorDao(IMajorDAO majorDao) {
		this.majorDao = majorDao;
	}

	@Override
	@Transactional
	public List<Major> allMajor() {
		return majorDao.allMajor();
	}

	@Override
	@Transactional
	public Major findById(int mID) {
		return majorDao.findById(mID);
	}

	@Override
	@Transactional
	public boolean updMajor(Major major) {
		return majorDao.updMajor(major);
	}

}
