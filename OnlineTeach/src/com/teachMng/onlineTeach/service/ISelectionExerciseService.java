package com.teachMng.onlineTeach.service;

import java.util.List;

import com.teachMng.onlineTeach.model.exercise.SelectionExercise;

public interface ISelectionExerciseService {
	List<SelectionExercise> allExercise();
	SelectionExercise findById(int id);
	boolean insert(SelectionExercise ce);
	String getCEString();	
	String quickLook(int id);	
}
