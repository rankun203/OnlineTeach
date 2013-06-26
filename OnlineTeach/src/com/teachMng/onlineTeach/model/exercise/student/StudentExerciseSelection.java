package com.teachMng.onlineTeach.model.exercise.student;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.teachMng.onlineTeach.model.Student;
import com.teachMng.onlineTeach.model.exercise.IExerciseStudent;
import com.teachMng.onlineTeach.model.exercise.IExerciseTeacher;
import com.teachMng.onlineTeach.model.exercise.teacher.IExerciseImplSelection;

/**
 * 学生做的选择题<br>
 * 老师布置题的时候，从TeacherExercise里面把每道题复制一份到学生题中，
 * 然后系统根据学生答题情况对题目进行作答，本接口只包含与学生作答相关的内容，
 * 比如学生给出的答案，以及
 * @author mindfine
 */
public class StudentExerciseSelection implements IExerciseStudent {

	private long id;
	private Selection selected;
	private IExerciseImplSelection originExercise;
	private String teacherComment;
	private double score;
	private Student student;
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
	
	@Override
	public String toString(){
		return "" + selected;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Override
	public long getId() {
		return id;
	}

	@Override
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public IExerciseTeacher getOriginExercise() {
		return originExercise;
	}

	@Override
	public void setOriginExercise(IExerciseTeacher originExercise) {
		this.originExercise = (IExerciseImplSelection)originExercise;
	}

	@Override
	public void setTeacherComment(String comment) {
		this.teacherComment = comment;
	}

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
	@Override
	public void setStudent(Student student) {
		this.student = student;
	}


	@Override
	public Student getStudent() {
		return student;
	}

}
