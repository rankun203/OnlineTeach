package com.teachMng.onlineTeach.service;

import java.util.List;

import com.teachMng.onlineTeach.model.exercise.ExerciseSetQuestionExercise;
import com.teachMng.onlineTeach.model.exercise.QuestionExercise;

public interface IExerciseSetQuestionExerciseService {
	List<ExerciseSetQuestionExercise> findByEsId(int esId);
	List<ExerciseSetQuestionExercise> findByQeId(int qeId);
	List<QuestionExercise> getQuestionExercise(int esId);
	ExerciseSetQuestionExercise findByEsIdQeId(int esId, int qeId);
	boolean update(ExerciseSetQuestionExercise esqe);
	boolean insert(ExerciseSetQuestionExercise esqe);
	boolean delete(ExerciseSetQuestionExercise esqe);
	boolean deleteByEsIdQeId(int esId, int qeId);
}
