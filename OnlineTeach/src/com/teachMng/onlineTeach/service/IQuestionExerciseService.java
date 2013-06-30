package com.teachMng.onlineTeach.service;

import java.util.List;

import com.teachMng.onlineTeach.model.exercise.QuestionExercise;

public interface IQuestionExerciseService {
	List<QuestionExercise> allExercise();
	QuestionExercise findById(int id);
	boolean insert(QuestionExercise qe);
	String getCEString();	
	String quickLook(int id);	
	String getAnswerInfo(int id);	
}
