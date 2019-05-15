package com.tcs.ilp.bean;

public class Address {
	private String sid;
	private String address;
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Address(String sid, String address) {
		super();
		this.sid = sid;
		this.address = address;
	}
	@Override
	public String toString() {
		return "Address [sid=" + sid + ", address=" + address + "]";
	}
	
}
