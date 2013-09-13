package com.teachMng.onlineTeach.dao;

import java.util.List;

import com.teachMng.onlineTeach.model.exercise.AnswerHistory;


public interface IAnswerHistoryDAO {
	List<AnswerHistory> findByEsId(int esId);
	List<AnswerHistory> findBytId(int tId, String type);
	List<AnswerHistory> findByEsIdtId(int esId, int tId, String type);
	boolean update(AnswerHistory ah);
	boolean insert(AnswerHistory ah);
	boolean delete(AnswerHistory ah);
	boolean deleteByEsIdtId(int esId, int tId);
}
