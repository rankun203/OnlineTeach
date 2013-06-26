package com.teachMng.onlineTeach.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * desc:文件类
 * */
@Entity
@Table(name = "t_file")
public class UpFile {
	private int fileID;
	private String filePaths;
	private String originalFileName;
	private String generateFileName;
	private Date uploadDateTime;
	private int downloadCount;
	private String comment;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getFileID() {
		return fileID;
	}
	public void setFileID(int fileID) {
		this.fileID = fileID;
	}
	public String getFilePaths() {
		return filePaths;
	}
	public void setFilePaths(String filePaths) {
		this.filePaths = filePaths;
	}
	public String getOriginalFileName() {
		return originalFileName;
	}
	public void setOriginalFileName(String originalFileName) {
		this.originalFileName = originalFileName;
	}
	public String getGenerateFileName() {
		return generateFileName;
	}
	public void setGenerateFileName(String generateFileName) {
		this.generateFileName = generateFileName;
	}
	public Date getUploadDateTime() {
		return uploadDateTime;
	}
	public void setUploadDateTime(Date uploadDateTime) {
		this.uploadDateTime = uploadDateTime;
	}
	public int getDownloadCount() {
		return downloadCount;
	}
	public void setDownloadCount(int downloadCount) {
		this.downloadCount = downloadCount;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
}
