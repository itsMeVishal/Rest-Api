package com.vish.security.security.demo.builders;

import java.util.Date;

import com.vish.security.security.demo.entity.FileModel;

public class FileModelBuilder {

	String fileName;
	byte[] content;
	Long fileSize;
	String fileType;
	Date dateUploaded;

	public FileModelBuilder() {
	}

	public FileModelBuilder setFileName(String fileName) {
		this.fileName = fileName;
		return this;
	}

	public FileModelBuilder setContent(byte[] content) {
		this.content = content;
		return this;
	}

	public FileModelBuilder setFileSize(Long fileSize) {
		this.fileSize = fileSize;
		return this;
	}

	public FileModelBuilder setFileType(String fileType) {
		this.fileType = fileType;
		return this;
	}

	public FileModelBuilder setDateUploaded(Date dateUploaded) {
		this.dateUploaded = dateUploaded;
		return this;
	}

	public FileModel build() {
		return new FileModel(this.fileName, this.content, this.fileSize, this.fileType, this.dateUploaded);
	}
}
