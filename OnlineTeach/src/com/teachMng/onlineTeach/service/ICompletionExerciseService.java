package com.teachMng.onlineTeach.service;

import java.util.List;

import com.teachMng.onlineTeach.model.exercise.CompletionExercise;

public interface ICompletionExerciseService {
	List<CompletionExercise> allExercise();
	CompletionExercise findById(int id);
	boolean insert(CompletionExercise ce);
	String getCEString();
	String quickLook(int id);
	String getAnswerInfo(int id);
}
