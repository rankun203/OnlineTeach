package com.teachMng.onlineTeach.model;

import java.util.Date;

/*
 * desc:ÎÄ¼þÀà
 * */
public class UpFile {
	private int fileID;
	private String filePaths;
	private String originalFileName;
	private String generateFileName;
	private Date uploadDateTime;
	private int downloadCount;
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
}
