package com.akshay.av.controller;

import java.io.File;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
@Lazy
@Scope("singleton")
public class FileBeanDTO {

	private File fileName;
	private MultipartFile multipartFile;

	private static int idFileProcess = 0;

	private FileBeanDTO() {
	}

	public int getIdFileProcess() {
		return ++idFileProcess;
	}

	public File getfileName() {
		return fileName;
	}

	public void setfileName(File fileName) {
		this.fileName = fileName;
	}

	public MultipartFile getMultipartFile() {
		return multipartFile;
	}

	public void setMultipartFile(MultipartFile multipartFile) {
		this.multipartFile = multipartFile;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[FileBeanDTO::"+this.multipartFile+ "]";
	}

}
