package com.tcs.ilp.bean;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Users {
	
	private String sid;
	private String name;
	private String dob;
	private String gender;
	private String phone;
	private String email;
	private String address;
	private String password;
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	private int sid_id;
	private int doc1;
	private int doc2;
	private int status;
	
	public Users(String sid, String name, String dob, String phone, String gender, String email, String address, String password, int sid_id, int doc1,
			int doc2) {
		super();
		this.sid = sid;
		this.name = name;
		this.dob = dob;
		this.gender = gender;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.sid_id = sid_id;
		this.doc1 = doc1;
		this.doc2 = doc2;
		this.status = 1;
		this.password = password;
	}
	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Users(){
		
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Users [sid=" + sid + ", name=" + name + ", dob=" + dob + ", phone=" + phone + ", email=" + email
				+ ", address=" + address + ", sid_id=" + sid_id + ", doc1=" + doc1 + ", doc2=" + doc2 + "]";
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getSid_id() {
		return sid_id;
	}

	public void setSid_id(int sid_id) {
		this.sid_id = sid_id;
	}

	public int getDoc1() {
		return doc1;
	}

	public void setDoc1(int doc1) {
		this.doc1 = doc1;
	}

	public int getDoc2() {
		return doc2;
	}

	public void setDoc2(int doc2) {
		this.doc2 = doc2;
	}
	
	

}
