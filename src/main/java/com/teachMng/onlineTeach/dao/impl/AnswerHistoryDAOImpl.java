package com.teachMng.onlineTeach.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.teachMng.onlineTeach.dao.IAnswerHistoryDAO;
import com.teachMng.onlineTeach.model.exercise.AnswerHistory;
@Component("answerHistoryDao")
public class AnswerHistoryDAOImpl implements IAnswerHistoryDAO  {
	private SessionFactory sf;

	public SessionFactory getSf() {
		return sf;
	}
	@Resource(name="sessionFactory")
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	@Override
	public List<AnswerHistory> findByEsId(int esId) {
		return null;
	}

	@Override
	public List<AnswerHistory> findBytId(int tId, String type) {
		return null;
	}

	@Override
	public List<AnswerHistory> findByEsIdtId(int esId, int tId, String type) {
		return null;
	}

	@Override
	public boolean update(AnswerHistory ah) {
		return false;
	}

	@Override
	public boolean insert(AnswerHistory ah) {
		Session s = sf.getCurrentSession();
		s.save(ah);
		return true;
	}

	@Override
	public boolean delete(AnswerHistory ah) {
		Session s = sf.getCurrentSession();
		s.delete(ah);
		return true;
	}

	@Override
	public boolean deleteByEsIdtId(int esId, int tId) {
		return false;
	}
}
