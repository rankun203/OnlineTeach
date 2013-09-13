package com.teachMng.onlineTeach.dao;

import java.util.List;

import com.teachMng.onlineTeach.model.exercise.ExerciseSetQuestionExercise;

public interface IExerciseSetQuestionExerciseDAO {
	List<ExerciseSetQuestionExercise> findByEsId(int esId);
	List<ExerciseSetQuestionExercise> findByQeId(int qeId);
	ExerciseSetQuestionExercise findByEsIdQeId(int esId, int qeId);
	boolean update(ExerciseSetQuestionExercise esqe);
	boolean insert(ExerciseSetQuestionExercise esqe);
	boolean delete(ExerciseSetQuestionExercise esqe);
	boolean deleteByEsIdQeId(int esId, int qeId);
}
