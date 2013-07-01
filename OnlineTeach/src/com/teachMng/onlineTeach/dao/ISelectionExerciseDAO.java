package com.teachMng.onlineTeach.dao;

import java.util.List;

import com.teachMng.onlineTeach.model.exercise.SelectionExercise;

public interface ISelectionExerciseDAO {
	List<SelectionExercise> allExercise();
	SelectionExercise findById(int id);
	boolean insert(SelectionExercise ce);
	boolean deleteById(int id);	
}
