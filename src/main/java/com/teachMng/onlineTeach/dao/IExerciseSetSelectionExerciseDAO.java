package com.teachMng.onlineTeach.dao;

import java.util.List;

import com.teachMng.onlineTeach.model.exercise.ExerciseSetSelectionExercise;

public interface IExerciseSetSelectionExerciseDAO {
	List<ExerciseSetSelectionExercise> findByEsId(int esId);
	List<ExerciseSetSelectionExercise> findBySeId(int seId);
	ExerciseSetSelectionExercise findByEsIdSeId(int esId, int seId);
	boolean update(ExerciseSetSelectionExercise esse);
	boolean insert(ExerciseSetSelectionExercise esse);
	boolean delete(ExerciseSetSelectionExercise esse);
	boolean deleteByEsIdSeId(int esId, int seId);
}
