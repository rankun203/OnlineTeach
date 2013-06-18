package com.teachMng.onlineTeach.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.teachMng.onlineTeach.dao.ICourseDAO;
import com.teachMng.onlineTeach.model.Course;
import com.teachMng.onlineTeach.service.ICourseService;
@Component("courseService")
public class CourseServiceImpl implements ICourseService {
	private ICourseDAO courseDao;
	public ICourseDAO getCourseDao() {
		return courseDao;
	}
	@Resource(name="courseDao")
	public void setCourseDao(ICourseDAO courseDao) {
		this.courseDao = courseDao;
	}

	@Override
	@Transactional
	public List<Course> allCourse() {
		return courseDao.allCourse();
	}

	@Override
	@Transactional
	public Course findById(int cID) {
		return courseDao.findById(cID);
	}

	@Override
	@Transactional
	public boolean updCourse(Course course) {
		// TODO Auto-generated method stub
		return courseDao.updCourse(course);
	}

}
