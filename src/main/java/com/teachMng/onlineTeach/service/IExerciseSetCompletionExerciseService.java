package com.teachMng.onlineTeach.service;

import java.util.List;

import com.teachMng.onlineTeach.model.exercise.CompletionExercise;
import com.teachMng.onlineTeach.model.exercise.ExerciseSetCompletionExercise;

public interface IExerciseSetCompletionExerciseService {
	List<ExerciseSetCompletionExercise> findByEsId(int esId);
	List<ExerciseSetCompletionExercise> findByCeId(int ceId);
	List<CompletionExercise> getCompletionExercise(int esId);
	ExerciseSetCompletionExercise findByEsIdCeId(int esId, int ceId);
	boolean update(ExerciseSetCompletionExercise esce);
	boolean insert(ExerciseSetCompletionExercise esce);
	boolean delete(ExerciseSetCompletionExercise esce);
	boolean deleteByEsIdCeId(int esId, int ceId);
}
