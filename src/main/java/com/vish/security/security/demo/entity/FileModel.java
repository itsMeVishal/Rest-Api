package com.vish.security.security.demo.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@JsonSerialize
public class FileModel {
	
	@Id
	@GeneratedValue
	Long id;
	String fileName;
	byte[] content;
	Long fileSize;
	String fileType;
	Date dateUploaded;
	
public FileModel(String originalFilename, byte[] bytes, long size, String contentType, Date date) {
	this.fileName = originalFilename;
	this.content = bytes;
	this.fileSize = size;
	this.fileType = contentType;
	this.dateUploaded = date;
	
	}
}
