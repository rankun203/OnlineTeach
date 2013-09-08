package com.teachMng.onlineTeach.service;

import java.util.List;

import com.teachMng.onlineTeach.model.exercise.CompletionExercise;
import com.teachMng.onlineTeach.model.exercise.ExerciseSet;
import com.teachMng.onlineTeach.model.exercise.JudgeExercise;
import com.teachMng.onlineTeach.model.exercise.QuestionExercise;
import com.teachMng.onlineTeach.model.exercise.SelectionExercise;

public interface IExerciseSetService {
	List<ExerciseSet> allExerciseSet();
	ExerciseSet findById(int id);
	ExerciseSet findByTeacherId(int tid);
	List<ExerciseSet> findByStudentId(int sid);
	boolean insert(ExerciseSet es);
	boolean save(ExerciseSet es);
	String getExerciseSet(int esID);
	
	List<SelectionExercise> getSelectionExerciseById(int esId);
	List<CompletionExercise> getCompletionExerciseById(int esId);
	List<JudgeExercise> getJudgeExerciseById(int esId);
	List<QuestionExercise> getQuestionExerciseById(int esId);	
}
