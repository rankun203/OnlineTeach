package com.teachMng.onlineTeach.dao;

import java.util.List;

import com.teachMng.onlineTeach.model.exercise.CompletionExercise;
import com.teachMng.onlineTeach.model.exercise.QuestionExercise;

public interface IQuestionExerciseDAO {
	List<QuestionExercise> allExercise();
	QuestionExercise findById(int id);
	boolean insert(QuestionExercise qe);
}
