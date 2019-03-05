package com.six.chunfeng.domain;

public class User {
	private String name;
	private String gender;
	private String birth;
	private String major;
	private String education;
	private String phone;
	private String password;
	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name 要设置的 name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return gender
	 */
	public String getGender() {
		return gender;
	}
	/**
	 * @param gender 要设置的 gender
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	/**
	 * @return birth
	 */
	public String getBirth() {
		return birth;
	}
	/**
	 * @param birth 要设置的 birth
	 */
	public void setBirth(String birth) {
		this.birth = birth;
	}
	/**
	 * @return major
	 */
	public String getMajor() {
		return major;
	}
	/**
	 * @param major 要设置的 major
	 */
	public void setMajor(String major) {
		this.major = major;
	}
	/**
	 * @return education
	 */
	public String getEducation() {
		return education;
	}
	/**
	 * @param education 要设置的 education
	 */
	public void setEducation(String education) {
		this.education = education;
	}
	/**
	 * @return phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone 要设置的 phone
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * @return password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password 要设置的 password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/* （非 Javadoc）
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [name=" + name + ", gender=" + gender + ", birth=" + birth + ", major=" + major + ", education="
				+ education + ", phone=" + phone + ", password=" + password + "]";
	}
	
	
}
