package com.bin;

public class emp_bo {

	private String id;
	private String name;
	private String email;
	private String phone;
	private String doj;
	private String dob;
	private String adhar;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDoj() {
		return doj;
	}

	public void setDoj(String doj) {
		this.doj = doj;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getAdhar() {
		return adhar;
	}

	public void setAdhar(String adhar) {
		this.adhar = adhar;
	}

	public emp_bo(String id, String name, String email, String phone, String doj, String dob, String adhar) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.doj = doj;
		this.dob = dob;
		this.adhar = adhar;
	}

	public emp_bo() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "\n id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", doj=" + doj + ", dob="
				+ dob + ", adhar=" + adhar;
	}

}
