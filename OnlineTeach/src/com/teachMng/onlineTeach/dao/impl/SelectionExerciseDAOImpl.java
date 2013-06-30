package com.teachMng.onlineTeach.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.teachMng.onlineTeach.dao.ISelectionExerciseDAO;
import com.teachMng.onlineTeach.model.exercise.SelectionExercise;
@Component("selectionExerciseDao")
public class SelectionExerciseDAOImpl implements ISelectionExerciseDAO {
	private SessionFactory sf;

	public SessionFactory getSf() {
		return sf;
	}
	@Resource(name="sessionFactory")
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	@Override
	public List<SelectionExercise> allExercise() {
		Session s = sf.getCurrentSession();
		return s.createQuery("from SelectionExercise").list();
	}

	@Override
	public SelectionExercise findById(int id) {
		return null;
	}

	@Override
	public boolean insert(SelectionExercise ce) {
		Session s = sf.getCurrentSession();
		int rows = (Integer) s.save(ce);
		if(rows > 0) return true;
		else return false;
	}

}
