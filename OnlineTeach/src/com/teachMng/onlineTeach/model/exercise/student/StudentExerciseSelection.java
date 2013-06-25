package com.teachMng.onlineTeach.model.exercise.student;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.teachMng.onlineTeach.model.exercise.IExerciseStudent;
import com.teachMng.onlineTeach.model.exercise.IExerciseTeacher;

/**
 * @author mindfine
 */
public class StudentExerciseSelection implements IExerciseStudent {

	private long id;
	private Selection selected;
	private IExerciseTeacher originExercise;
	private enum Selection{
		A,
		B,
		C,
		D
	}
	
	/**
	 * 读取选项
	 */
	public Selection getSelected() {
		return selected;
	}
	
	/**
	 * 设置选项
	 * @param selected 设置的选项
	 */
	public void setSelected(Selection selected) {
		this.selected = selected;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString(){
		return "" + selected;
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
	/* (non-Javadoc)
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
