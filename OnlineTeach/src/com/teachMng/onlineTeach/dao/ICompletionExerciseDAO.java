package com.teachMng.onlineTeach.dao;

import java.util.List;

import com.teachMng.onlineTeach.model.exercise.CompletionExercise;

public interface ICompletionExerciseDAO {
	List<CompletionExercise> allExercise();
	CompletionExercise findById(int id);
	boolean insert(CompletionExercise ce);
	boolean deleteById(int id);
}
