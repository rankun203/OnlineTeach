package com.teachMng.onlineTeach.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.teachMng.onlineTeach.dao.IAnswerHistoryDAO;
import com.teachMng.onlineTeach.model.exercise.AnswerHistory;
import com.teachMng.onlineTeach.service.IAnswerHistoryService;
@Transactional
@Component("answerHistoryService")
public class AnswerHistoryServiceImpl implements IAnswerHistoryService  {
	private IAnswerHistoryDAO answerhistoryDao;
	public IAnswerHistoryDAO getAnswerhistoryDao() {
		return answerhistoryDao;
	}
	@Resource(name="answerHistoryDao")
	public void setAnswerhistoryDao(IAnswerHistoryDAO answerhistoryDao) {
		this.answerhistoryDao = answerhistoryDao;
	}

	@Override
	public List<AnswerHistory> findByEsId(int esId) {
		return answerhistoryDao.findByEsId(esId);
	}

	@Override
	public List<AnswerHistory> findBytId(int tId, String type) {
		return answerhistoryDao.findBytId(tId, type);
	}

	@Override
	public List<AnswerHistory> findByEsIdtId(int esId, int tId, String type) {
		return answerhistoryDao.findByEsIdtId(esId, tId, type);
	}

	@Override
	public boolean update(AnswerHistory ah) {
		return answerhistoryDao.update(ah);
	}

	@Override
	public boolean insert(AnswerHistory ah) {
		return answerhistoryDao.insert(ah);
	}

	@Override
	public boolean delete(AnswerHistory ah) {
		return answerhistoryDao.delete(ah);
	}

	@Override
	public boolean deleteByEsIdtId(int esId, int tId) {
		return answerhistoryDao.deleteByEsIdtId(esId, tId);
	}

}
