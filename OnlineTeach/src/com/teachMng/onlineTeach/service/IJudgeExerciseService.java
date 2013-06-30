package com.teachMng.onlineTeach.service;

import java.util.List;

import com.teachMng.onlineTeach.model.exercise.CompletionExercise;
import com.teachMng.onlineTeach.model.exercise.JudgeExercise;

public interface IJudgeExerciseService {
	List<JudgeExercise> allExercise();
	JudgeExercise findById(int id);
	boolean insert(JudgeExercise je);
}
