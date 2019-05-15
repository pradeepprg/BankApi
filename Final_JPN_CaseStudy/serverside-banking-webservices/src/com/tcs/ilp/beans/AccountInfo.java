package com.tcs.ilp.beans;


import java.io.InputStream;
import java.util.Date;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

public class AccountInfo {

	private @FormDataParam("sid") String sid;
	private @FormDataParam("name") String name;
	private @FormDataParam("dob") String dob;
	private @FormDataParam("phone") String phone;
	private @FormDataParam("email") String email;
	private @FormDataParam("address") String address;
	private @FormDataParam("password") String password;
	
	private @FormDataParam("gender") String gender;
	private @FormDataParam("type") String type;
	
	@FormDataParam("sid_doc") InputStream uploadedInputStream_sid;
	@FormDataParam("sid_doc") FormDataContentDisposition fileDetail_sid;
	
	@FormDataParam("doc1") InputStream uploadedInputStream_doc1;
	@FormDataParam("doc1") FormDataContentDisposition fileDetail_doc1;
	
	@FormDataParam("doc2") InputStream uploadedInputStream_doc2;
	@FormDataParam("doc2") FormDataContentDisposition fileDetail_doc2;
	
	public AccountInfo(){
		
	}

	public AccountInfo(String sid, String name,String phone, String dob, String gender, String type, String email, String address,String password,
			InputStream uploadedInputStream_sid, FormDataContentDisposition fileDetail_sid,
			InputStream uploadedInputStream_doc1, FormDataContentDisposition fileDetail_doc1,
			InputStream uploadedInputStream_doc2, FormDataContentDisposition fileDetail_doc2) {
		super();
		this.sid = sid;
		this.name = name;
		this.dob = dob;
		this.phone = phone;
		this.email = email;
		this.gender = gender;
		this.type = type;
		this.address = address;
		this.password = password;
		this.uploadedInputStream_sid = uploadedInputStream_sid;
		this.fileDetail_sid = fileDetail_sid;
		this.uploadedInputStream_doc1 = uploadedInputStream_doc1;
		this.fileDetail_doc1 = fileDetail_doc1;
		this.uploadedInputStream_doc2 = uploadedInputStream_doc2;
		this.fileDetail_doc2 = fileDetail_doc2;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "AccountInfo [sid=" + sid + ", name=" + name + ", dob=" + dob + ", phone=" + phone + ", email=" + email
				+ ", address=" + address + ", uploadedInputStream_sid=" + uploadedInputStream_sid + ", fileDetail_sid="
				+ fileDetail_sid + ", uploadedInputStream_doc1=" + uploadedInputStream_doc1 + ", fileDetail_doc1="
				+ fileDetail_doc1 + ", uploadedInputStream_doc2=" + uploadedInputStream_doc2 + ", fileDetail_doc2="
				+ fileDetail_doc2 + "]";
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

	public InputStream getUploadedInputStream_sid() {
		return uploadedInputStream_sid;
	}

	public void setUploadedInputStream_sid(InputStream uploadedInputStream_sid) {
		this.uploadedInputStream_sid = uploadedInputStream_sid;
	}

	public FormDataContentDisposition getFileDetail_sid() {
		return fileDetail_sid;
	}

	public void setFileDetail_sid(FormDataContentDisposition fileDetail_sid) {
		this.fileDetail_sid = fileDetail_sid;
	}

	public InputStream getUploadedInputStream_doc1() {
		return uploadedInputStream_doc1;
	}

	public void setUploadedInputStream_doc1(InputStream uploadedInputStream_doc1) {
		this.uploadedInputStream_doc1 = uploadedInputStream_doc1;
	}

	public FormDataContentDisposition getFileDetail_doc1() {
		return fileDetail_doc1;
	}

	public void setFileDetail_doc1(FormDataContentDisposition fileDetail_doc1) {
		this.fileDetail_doc1 = fileDetail_doc1;
	}

	public InputStream getUploadedInputStream_doc2() {
		return uploadedInputStream_doc2;
	}

	public void setUploadedInputStream_doc2(InputStream uploadedInputStream_doc2) {
		this.uploadedInputStream_doc2 = uploadedInputStream_doc2;
	}

	public FormDataContentDisposition getFileDetail_doc2() {
		return fileDetail_doc2;
	}

	public void setFileDetail_doc2(FormDataContentDisposition fileDetail_doc2) {
		this.fileDetail_doc2 = fileDetail_doc2;
	}
	
	
	
	
}
