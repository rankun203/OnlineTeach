package com.teachMng.onlineTeach.model.exercise.student;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.teachMng.onlineTeach.model.exercise.IExerciseStudent;
import com.teachMng.onlineTeach.model.exercise.IExerciseTeacher;

/**
 * @author mindfine
 */
public class StudentExerciseJudge implements IExerciseStudent {

	private long id;
	private boolean answer;
	private IExerciseTeacher originExercise;
	
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
		this.originExercise = originExercise;
	}

}
