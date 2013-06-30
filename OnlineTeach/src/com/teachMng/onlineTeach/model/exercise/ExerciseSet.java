package com.teachMng.onlineTeach.model.exercise;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Index;

import com.teachMng.onlineTeach.model.Student;
import com.teachMng.onlineTeach.model.Teacher;

/**
 * 试题集，好比一张试卷
 * @author mindfine
 */
@Entity
@Table(name="t_exerciseset")
public class ExerciseSet {

	private int id;
	private Teacher founder;
	/**
	 * 如果给了student的值，则说明这张试卷下发给某学生<br>
	 * 学生试题集与学生是多对一的关系，一个试题集只能属于零个或者一个学生，
	 * 但一个学生可能会有很多试题集
	 */
	private Student student;

	private List<JudgeExercise> judgeExercise = new ArrayList<JudgeExercise>();
	private List<CompletionExercise> completionExercise = new ArrayList<CompletionExercise>();
	private List<QuestionExercise> questionExercise = new ArrayList<QuestionExercise>();
	private List<SelectionExercise> selectionExercise = new ArrayList<SelectionExercise>();

	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="teacId")
	public Teacher getFounder() {
		return founder;
	}
	public void setFounder(Teacher founder) {
		this.founder = founder;
	}
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="stuId")
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	@ManyToMany(cascade=CascadeType.MERGE)
	public List<JudgeExercise> getJudgeExercise() {
		return judgeExercise;
	}
	public void setJudgeExercise(List<JudgeExercise> judgeExercise) {
		this.judgeExercise = judgeExercise;
	}
	@ManyToMany(cascade=CascadeType.MERGE)
	public List<CompletionExercise> getCompletionExercise() {
		return completionExercise;
	}
	public void setCompletionExercise(List<CompletionExercise> completionExercise) {
		this.completionExercise = completionExercise;
	}
	@ManyToMany(cascade=CascadeType.MERGE)
	public List<QuestionExercise> getQuestionExercise() {
		return questionExercise;
	}
	public void setQuestionExercise(List<QuestionExercise> questionExercise) {
		this.questionExercise = questionExercise;
	}
	@ManyToMany(cascade=CascadeType.MERGE)
	public List<SelectionExercise> getSelectionExercise() {
		return selectionExercise;
	}
	public void setSelectionExercise(List<SelectionExercise> selectionExercise) {
		this.selectionExercise = selectionExercise;
	}
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

}
