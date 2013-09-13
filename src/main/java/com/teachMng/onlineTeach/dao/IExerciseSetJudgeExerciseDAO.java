package com.teachMng.onlineTeach.dao;

import java.util.List;

import com.teachMng.onlineTeach.model.exercise.ExerciseSetJudgeExercise;

public interface IExerciseSetJudgeExerciseDAO {
	List<ExerciseSetJudgeExercise> findByEsId(int esId);
	List<ExerciseSetJudgeExercise> findByJeId(int jeId);
	ExerciseSetJudgeExercise findByEsIdJeId(int esId, int jeId);
	boolean update(ExerciseSetJudgeExercise esje);
	boolean insert(ExerciseSetJudgeExercise esje);
	boolean delete(ExerciseSetJudgeExercise esje);
	boolean deleteByEsIdJeId(int esId, int jeId);
}
