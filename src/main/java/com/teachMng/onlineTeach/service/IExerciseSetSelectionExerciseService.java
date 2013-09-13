package com.teachMng.onlineTeach.service;

import java.util.List;

import com.teachMng.onlineTeach.model.exercise.ExerciseSetSelectionExercise;
import com.teachMng.onlineTeach.model.exercise.SelectionExercise;

public interface IExerciseSetSelectionExerciseService {
	List<ExerciseSetSelectionExercise> findByEsId(int esId);
	List<ExerciseSetSelectionExercise> findBySeId(int seId);
	List<SelectionExercise> getSelectionExercise(int esId);
	ExerciseSetSelectionExercise findByEsIdSeId(int esId, int seId);
	boolean update(ExerciseSetSelectionExercise esse);
	boolean insert(ExerciseSetSelectionExercise esse);
	boolean delete(ExerciseSetSelectionExercise esse);
	boolean deleteByEsIdSeId(int esId, int seId);
}
