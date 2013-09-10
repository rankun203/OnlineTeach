package com.teachMng.onlineTeach.dao;

import java.util.List;

import com.teachMng.onlineTeach.model.exercise.JudgeExercise;

public interface IJudgeExerciseDAO {
	List<JudgeExercise> allExercise();
	JudgeExercise findById(int id);
	boolean insert(JudgeExercise je);
	boolean deleteById(int id);	
}
