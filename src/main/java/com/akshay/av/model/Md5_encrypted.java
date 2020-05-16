package com.akshay.av.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Entity
@JsonPropertyOrder({"ID","md5String","ransomWare"})
@Component
public class Md5_encrypted {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer ID;		
	@Column(name="MD5String",nullable=false,length=512)
	private String md5String;
	@Column(name="Ransom_Ware",nullable=false,length=512)
	private String ransomWare;

	public Md5_encrypted() {
	}
	
	public Md5_encrypted(String md5String,String ransomWare) {
		this.md5String=md5String;
		this.ransomWare=ransomWare;
	}

	public String getMd5() {
		return md5String;
	}

	public void setMd5(String md5String) {
		this.md5String = md5String;
	}

	public Number getMd5Id() {
		return ID;
	}

	public void setID(Integer ID) {
		this.ID = ID;
	}

	public String getRansomWare() {
		return ransomWare;
	}

	public void setRansomWare(String ransomWare) {
		this.ransomWare = ransomWare;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "" + ID + "" + md5String + " " + ransomWare;
	}
}
