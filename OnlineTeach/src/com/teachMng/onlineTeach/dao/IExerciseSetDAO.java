package com.teachMng.onlineTeach.dao;

import java.util.List;

import com.teachMng.onlineTeach.model.exercise.ExerciseSet;

public interface IExerciseSetDAO {
	List<ExerciseSet> allExerciseSet();
	ExerciseSet findById(int id);
	ExerciseSet findByTeacherId(int tid);
	ExerciseSet findByStudentId(int sid);
	boolean insert(ExerciseSet es);
	boolean save(ExerciseSet es);
}
