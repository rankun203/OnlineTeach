package com.teachMng.onlineTeach.service;

import java.util.List;

import com.teachMng.onlineTeach.model.exercise.ExerciseSetJudgeExercise;
import com.teachMng.onlineTeach.model.exercise.JudgeExercise;

public interface IExerciseSetJudgeExerciseService {
	List<ExerciseSetJudgeExercise> findByEsId(int esId);
	List<ExerciseSetJudgeExercise> findByJeId(int jeId);
	List<JudgeExercise> getJudgeExercise(int esId);
	ExerciseSetJudgeExercise findByEsIdJeId(int esId, int jeId);
	boolean update(ExerciseSetJudgeExercise esje);
	boolean insert(ExerciseSetJudgeExercise esje);
	boolean delete(ExerciseSetJudgeExercise esje);
	boolean deleteByEsIdJeId(int esId, int jeId);
}
