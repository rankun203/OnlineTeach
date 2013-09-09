package com.teachMng.onlineTeach.model.exercise;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.teachMng.onlineTeach.model.Student;
import com.teachMng.onlineTeach.model.Teacher;

/**
 * 试题集，好比一张试卷
 * 
 * @author mindfine
 */
@Entity
@Table(name = "t_exerciseset")
public class ExerciseSet {

	private int id;
	private Teacher founder;
	/**
	 * 如果给了student的值，则说明这张试卷下发给某学生<br>
	 * 学生试题集与学生是多对一的关系，一个试题集只能属于零个或者一个学生， 但一个学生可能会有很多试题集
	 */
	private Student student;
	private Date createDate;

	// private List<JudgeExercise> judgeExercise = new
	// ArrayList<JudgeExercise>();
	// private List<CompletionExercise> completionExercise = new
	// ArrayList<CompletionExercise>();
	// private List<QuestionExercise> questionExercise = new
	// ArrayList<QuestionExercise>();
	// private List<SelectionExercise> selectionExercise = new
	// ArrayList<SelectionExercise>();

	private List<ExerciseSetCompletionExercise> esce = new ArrayList<ExerciseSetCompletionExercise>();
	private List<ExerciseSetJudgeExercise> esje = new ArrayList<ExerciseSetJudgeExercise>();
	private List<ExerciseSetQuestionExercise> esqe = new ArrayList<ExerciseSetQuestionExercise>();
	private List<ExerciseSetSelectionExercise> esse = new ArrayList<ExerciseSetSelectionExercise>();

	@OneToMany(mappedBy = "es", cascade = CascadeType.ALL)
	public List<ExerciseSetSelectionExercise> getEsse() {
		return esse;
	}

	public void setEsse(List<ExerciseSetSelectionExercise> esse) {
		this.esse = esse;
	}

	@OneToMany(mappedBy = "es", cascade = CascadeType.ALL)
	public List<ExerciseSetQuestionExercise> getEsqe() {
		return esqe;
	}

	public void setEsqe(List<ExerciseSetQuestionExercise> esqe) {
		this.esqe = esqe;
	}

	@OneToMany(mappedBy = "es", cascade = CascadeType.ALL)
	public List<ExerciseSetJudgeExercise> getEsje() {
		return esje;
	}

	public void setEsje(List<ExerciseSetJudgeExercise> esje) {
		this.esje = esje;
	}

	@OneToMany(mappedBy = "es", cascade = CascadeType.ALL)
	public List<ExerciseSetCompletionExercise> getEsce() {
		return esce;
	}

	public void setEsce(List<ExerciseSetCompletionExercise> esce) {
		this.esce = esce;
	}

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "teacId")
	public Teacher getFounder() {
		return founder;
	}

	public void setFounder(Teacher founder) {
		this.founder = founder;
	}

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "stuId")
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	// @ManyToMany(cascade=CascadeType.MERGE)
	// @JoinTable(name="t_exerciseSet_t_judgeexercise",
	// joinColumns=@JoinColumn(name="esID"),
	// inverseJoinColumns=@JoinColumn(name="jeID"))
	// public List<JudgeExercise> getJudgeExercise() {
	// return judgeExercise;
	// }
	// public void setJudgeExercise(List<JudgeExercise> judgeExercise) {
	// this.judgeExercise = judgeExercise;
	// }
	// @ManyToMany(cascade=CascadeType.MERGE)
	// @JoinTable(name="t_exerciseSet_t_completionexercise",
	// joinColumns=@JoinColumn(name="esID"),
	// inverseJoinColumns=@JoinColumn(name="ceID"))
	// public List<CompletionExercise> getCompletionExercise() {
	// return completionExercise;
	// }
	// public void setCompletionExercise(List<CompletionExercise>
	// completionExercise) {
	// this.completionExercise = completionExercise;
	// }
	// @ManyToMany(cascade=CascadeType.MERGE)
	// @JoinTable(name="t_exerciseSet_t_questionexercise",
	// joinColumns=@JoinColumn(name="esID"),
	// inverseJoinColumns=@JoinColumn(name="qeID"))
	// public List<QuestionExercise> getQuestionExercise() {
	// return questionExercise;
	// }
	// public void setQuestionExercise(List<QuestionExercise> questionExercise)
	// {
	// this.questionExercise = questionExercise;
	// }
	// @ManyToMany(cascade=CascadeType.MERGE)
	// @JoinTable(name="t_exerciseSet_t_selectionexercise",
	// joinColumns=@JoinColumn(name="esID"),
	// inverseJoinColumns=@JoinColumn(name="seID"))
	// public List<SelectionExercise> getSelectionExercise() {
	// return selectionExercise;
	// }
	// public void setSelectionExercise(List<SelectionExercise>
	// selectionExercise) {
	// this.selectionExercise = selectionExercise;
	// }
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

}
