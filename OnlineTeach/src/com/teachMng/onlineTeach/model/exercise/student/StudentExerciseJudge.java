package com.teachMng.onlineTeach.model.exercise.student;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.teachMng.onlineTeach.model.exercise.IExerciseStudent;
import com.teachMng.onlineTeach.model.exercise.IExerciseTeacher;
import com.teachMng.onlineTeach.model.exercise.teacher.IExerciseImplJudge;

/**
 * @author mindfine
 */
public class StudentExerciseJudge implements IExerciseStudent {

	private long id;
	private boolean answer;
	private IExerciseImplJudge originExercise;
	private String teacherComment;
	private double score;
	
	/**
	 * 设置答案
	 * @param answer 要设置的答案
	 */
	public void setAnswer(boolean answer){
		this.answer = answer;
	}
	/**
	 * 读取答案
	 * @return boolean值，表示答案的对错
	 */
	public boolean getAnswer(){
		return answer;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString(){
		return "" + answer;
	}

	/* (non-Javadoc)
	 * @see com.teachMng.onlineTeach.model.exercise.IExercise#getId()
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Override
	public long getId() {
		return id;
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.teachMng.onlineTeach.model.exercise.IExercise#setId(int)
	 */
	@Override
	public void setId(int id) {
		this.id = id;
	}

	/* (non-Javadoc)
	 * @see com.teachMng.onlineTeach.model.exercise.IExerciseStudent#getOriginExercise()
	 */
	@Override
	public IExerciseTeacher getOriginExercise() {
		return originExercise;
	}

	/* (non-Javadoc)
	 * @see com.teachMng.onlineTeach.model.exercise.IExerciseStudent#setOriginExercise(com.teachMng.onlineTeach.model.exercise.IExerciseTeacher)
	 */
	@Override
	public void setOriginExercise(IExerciseTeacher originExercise) {
		this.originExercise = (IExerciseImplJudge)originExercise;
	}
	/* (non-Javadoc)
	 * @see com.teachMng.onlineTeach.model.exercise.IExerciseStudent#setTeacherComment(java.lang.String)
	 */
	@Override
	public void setTeacherComment(String comment) {
		this.teacherComment = comment;
	}

	/* (non-Javadoc)
	 * @see com.teachMng.onlineTeach.model.exercise.IExerciseStudent#getTeacherComment()
	 */
	@Override
	public String getTeacherComment() {
		return teacherComment;
	}
	@Override
	public double getScore() {
		return score;
	}

	@Override
	public void setScore(double score) {
		this.score = score;
	}

}
