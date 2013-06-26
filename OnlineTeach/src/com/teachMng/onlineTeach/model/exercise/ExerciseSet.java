package com.teachMng.onlineTeach.model.exercise;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.teachMng.onlineTeach.model.Student;
import com.teachMng.onlineTeach.model.Teacher;

/**
 * 试题集，好比一张试卷
 * @author mindfine
 */
public class ExerciseSet {

	private long id;
	private Teacher founder;
	/**
	 * 如果给了student的值，则说明这张试卷下发给某学生<br>
	 * 学生试题集与学生是多对一的关系，一个试题集只能属于零个或者一个学生，
	 * 但一个学生可能会有很多试题集
	 */
	private Student student;

	private JudgeExercise judgeExercise;
	private CompletionExercise completionExercise;
	private QuestionExercise questionExercise;
	private SelectionExercise selectionExercise;
	
	@ManyToOne
	@JoinColumn(name="teacId")
	public Teacher getFounder() {
		return founder;
	}
	public void setFounder(Teacher founder) {
		this.founder = founder;
	}
	@ManyToOne
	@JoinColumn(name="stuId")
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public JudgeExercise getJudgeExercise() {
		return judgeExercise;
	}
	public void setJudgeExercise(JudgeExercise judgeExercise) {
		this.judgeExercise = judgeExercise;
	}
	public CompletionExercise getCompletionExercise() {
		return completionExercise;
	}
	public void setCompletionExercise(CompletionExercise completionExercise) {
		this.completionExercise = completionExercise;
	}
	public QuestionExercise getQuestionExercise() {
		return questionExercise;
	}
	public void setQuestionExercise(QuestionExercise questionExercise) {
		this.questionExercise = questionExercise;
	}
	public SelectionExercise getSelectionExercise() {
		return selectionExercise;
	}
	public void setSelectionExercise(SelectionExercise selectionExercise) {
		this.selectionExercise = selectionExercise;
	}
	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	

}
