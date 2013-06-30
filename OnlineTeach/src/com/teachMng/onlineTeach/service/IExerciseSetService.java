package com.teachMng.onlineTeach.service;

import java.util.List;

import com.teachMng.onlineTeach.model.exercise.ExerciseSet;

public interface IExerciseSetService {
	List<ExerciseSet> allExerciseSet();
	ExerciseSet findById(int id);
	ExerciseSet findByTeacherId(int tid);
	ExerciseSet findByStudentId(int sid);
	boolean insert(ExerciseSet es);
}
