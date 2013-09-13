package com.teachMng.onlineTeach.model.exercise;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * 学生答题记录
 */
@Entity
@Table(name="t_answerhistory")
public class AnswerHistory {
	private int id;
	private int esId;
	private int tId;
	private String type;
	private Date date = new Date();
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getEsId() {
		return esId;
	}
	public void setEsId(int esId) {
		this.esId = esId;
	}
	public int gettId() {
		return tId;
	}
	public void settId(int tId) {
		this.tId = tId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
