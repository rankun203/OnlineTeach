package com.teachMng.onlineTeach.dao;

import java.util.List;

import com.teachMng.onlineTeach.model.exercise.ExerciseSetCompletionExercise;

public interface IExerciseSetCompletionExerciseDAO {
	List<ExerciseSetCompletionExercise> findByEsId(int esId);
	List<ExerciseSetCompletionExercise> findByCeId(int ceId);
	ExerciseSetCompletionExercise findByEsIdCeId(int esId, int ceId);
	boolean update(ExerciseSetCompletionExercise esce);
	boolean insert(ExerciseSetCompletionExercise esce);
	boolean delete(ExerciseSetCompletionExercise esce);
	boolean deleteByEsIdCeId(int esId, int ceId);
}
