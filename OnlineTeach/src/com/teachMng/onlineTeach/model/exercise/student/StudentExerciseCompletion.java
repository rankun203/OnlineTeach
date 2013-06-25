package com.teachMng.onlineTeach.model.exercise.student;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.teachMng.onlineTeach.model.Student;
import com.teachMng.onlineTeach.model.UpFile;
import com.teachMng.onlineTeach.model.exercise.IExerciseStudent;
import com.teachMng.onlineTeach.model.exercise.IExerciseTeacher;
import com.teachMng.onlineTeach.model.exercise.teacher.IExerciseImplCompletion;

/**
 * @author mindfine
 */
public class StudentExerciseCompletion implements IExerciseStudent {

	private long id;
	private List<UpFile> topicAttachments = new LinkedList<UpFile>();
	private List<String> answers = new LinkedList<String>();
	private IExerciseImplCompletion originExercise;
	private String teacherComment;
	private double score;
	private Student student;


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

	/**
	 * 添加一个答案，按顺序依次为题目答案的第一个空、第二个空……
	 * 
	 * @param answer
	 *            答案
	 */
	public void addAnswer(String answer) {
		if(answers.size() == originExercise.getSpaceCount()) {
			System.err.println("StudentExerciseCompletion#addAnswer:答案(" + originExercise.getSpaceCount() + "个)已经够了！");
			return;
		}
		this.answers.add(answer);
	}

	/**
	 * 获取答案
	 * 
	 * @return 答案集
	 */
	public List<String> getAnswers() {
		return answers;
	}

	/**
	 * 给题目添加一个附件
	 */
	public void addTopicAttachments(UpFile file) {
		topicAttachments.add(file);
	}

	/**
	 * 获取所有题目的附件
	 * 
	 * @return 附件链表
	 */
	public List<UpFile> getTopicAttachments() {
		return topicAttachments;
	}


	@Override
	public String toString() {
		String desc = "";
		for (int i = 1; i <= answers.size(); i++) {
			desc += "第" + i + "空：" + answers.get(i - 1) + "；";
		}
		return desc;
	}


	@Override
	public IExerciseTeacher getOriginExercise() {
		return originExercise;
	}

	@Override
	public void setOriginExercise(IExerciseTeacher originExercise) {
		this.originExercise = (IExerciseImplCompletion)originExercise;
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
