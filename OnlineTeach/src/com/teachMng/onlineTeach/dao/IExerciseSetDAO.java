package com.teachMng.onlineTeach.dao;

import java.util.List;

import com.teachMng.onlineTeach.model.exercise.CompletionExercise;
import com.teachMng.onlineTeach.model.exercise.ExerciseSet;
import com.teachMng.onlineTeach.model.exercise.JudgeExercise;
import com.teachMng.onlineTeach.model.exercise.QuestionExercise;
import com.teachMng.onlineTeach.model.exercise.SelectionExercise;

import com.teachMng.onlineTeach.model.exercise.JudgeExercise;
import com.teachMng.onlineTeach.model.exercise.QuestionExercise;
import com.teachMng.onlineTeach.model.exercise.SelectionExercise;

public interface IExerciseSetDAO {
	List<ExerciseSet> allExerciseSet();
	ExerciseSet findById(int id);
	ExerciseSet findByTeacherId(int tid);
	List<ExerciseSet> findByStudentId(int sid);
	boolean insert(ExerciseSet es);
	boolean save(ExerciseSet es);
}
