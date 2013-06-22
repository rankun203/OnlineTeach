package com.teachMng.onlineTeach.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.teachMng.onlineTeach.dao.IStudentDAO;
import com.teachMng.onlineTeach.model.Student;
import com.teachMng.onlineTeach.service.IStudentService;
@Component("studentService")
public class StudentServiceImpl implements IStudentService {
	private IStudentDAO studentDao;
	public IStudentDAO getStudentDao() {
		return studentDao;
	}
	@Resource(name="studentDao")
	public void setStudentDao(IStudentDAO studentDao) {
		this.studentDao = studentDao;
	}

	@Transactional
	@Override
	public List<Student> allStudent() {
		return studentDao.allStudent();
	}
	@Transactional
	@Override
	public Student findById(int sID) {
		return studentDao.findById(sID);
	}

	@Transactional
	@Override
	public boolean updStudent(Student stu) {
		return studentDao.updStudent(stu);
	}

}
