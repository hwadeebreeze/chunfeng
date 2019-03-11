package com.six.chunfeng.domain;

public class TagInfo {
	private int id;
	private int userId;
	private int workYear;
	private int salaryLeast;
	private int salaryMost;
	private String city;
	private String capacity;
	private String position;
	private String welfare;
	private String industry;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getWorkYear() {
		return workYear;
	}
	public void setWorkYear(int workYear) {
		this.workYear = workYear;
	}
	public int getSalaryLeast() {
		return salaryLeast;
	}
	public void setSalaryLeast(int salaryLeast) {
		this.salaryLeast = salaryLeast;
	}
	public int getSalaryMost() {
		return salaryMost;
	}
	public void setSalaryMost(int salaryMost) {
		this.salaryMost = salaryMost;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCapacity() {
		return capacity;
	}
	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getWelfare() {
		return welfare;
	}
	public void setWelfare(String welfare) {
		this.welfare = welfare;
	}
	public String getIndustry() {
		return industry;
	}
	public void setIndustry(String industry) {
		this.industry = industry;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((capacity == null) ? 0 : capacity.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + id;
		result = prime * result
				+ ((industry == null) ? 0 : industry.hashCode());
		result = prime * result
				+ ((position == null) ? 0 : position.hashCode());
		result = prime * result + salaryLeast;
		result = prime * result + salaryMost;
		result = prime * result + userId;
		result = prime * result + ((welfare == null) ? 0 : welfare.hashCode());
		result = prime * result + workYear;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TagInfo other = (TagInfo) obj;
		if (capacity == null) {
			if (other.capacity != null)
				return false;
		} else if (!capacity.equals(other.capacity))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (id != other.id)
			return false;
		if (industry == null) {
			if (other.industry != null)
				return false;
		} else if (!industry.equals(other.industry))
			return false;
		if (position == null) {
			if (other.position != null)
				return false;
		} else if (!position.equals(other.position))
			return false;
		if (salaryLeast != other.salaryLeast)
			return false;
		if (salaryMost != other.salaryMost)
			return false;
		if (userId != other.userId)
			return false;
		if (welfare == null) {
			if (other.welfare != null)
				return false;
		} else if (!welfare.equals(other.welfare))
			return false;
		if (workYear != other.workYear)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "TagInfo [id=" + id + ", userId=" + userId + ", workYear="
				+ workYear + ", salaryLeast=" + salaryLeast + ", salaryMost="
				+ salaryMost + ", city=" + city + ", capacity=" + capacity
				+ ", position=" + position + ", welfare=" + welfare
				+ ", industry=" + industry + "]";
	}
	
}
	
	