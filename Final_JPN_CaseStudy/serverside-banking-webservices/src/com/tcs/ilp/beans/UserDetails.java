package com.tcs.ilp.beans;

	public class UserDetails {
		String name ; 
		String phone ; 
		String address ; 
		String accno;
		@Override
		public String toString() {
			return "UserDetails [name=" + name + ", phone=" + phone + ", address=" + address + ", accno=" + accno + "]";
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getAccno() {
			return accno;
		}
		public void setAccno(String accno) {
			this.accno = accno;
		}
		public UserDetails(String name, String phone, String address, String accno) {
			super();
			this.name = name;
			this.phone = phone;
			this.address = address;
			this.accno = accno;
		}
		public UserDetails() {
			super();
		}
}
