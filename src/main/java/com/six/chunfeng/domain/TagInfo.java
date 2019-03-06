package com.six.chunfeng.domain;

public class TagInfo {
	private int id;
	private int workYear;
	private int salaryLeast;
	private int salaryMost;
	private String city;
	private String capacity;
	private String position;
	private String welfare;
	private String industry;
	/**
	 * @return id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id 要设置的 id
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return workYear
	 */
	public int getWorkYear() {
		return workYear;
	}
	/**
	 * @param workYear 要设置的 workYear
	 */
	public void setWorkYear(int workYear) {
		this.workYear = workYear;
	}
	/**
	 * @return salaryLeast
	 */
	public int getSalaryLeast() {
		return salaryLeast;
	}
	/**
	 * @param salaryLeast 要设置的 salaryLeast
	 */
	public void setSalaryLeast(int salaryLeast) {
		this.salaryLeast = salaryLeast;
	}
	/**
	 * @return salaryMost
	 */
	public int getSalaryMost() {
		return salaryMost;
	}
	/**
	 * @param salaryMost 要设置的 salaryMost
	 */
	public void setSalaryMost(int salaryMost) {
		this.salaryMost = salaryMost;
	}
	/**
	 * @return city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city 要设置的 city
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return capacity
	 */
	public String getCapacity() {
		return capacity;
	}
	/**
	 * @param capacity 要设置的 capacity
	 */
	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}
	/**
	 * @return position
	 */
	public String getPosition() {
		return position;
	}
	/**
	 * @param position 要设置的 position
	 */
	public void setPosition(String position) {
		this.position = position;
	}
	/**
	 * @return welfare
	 */
	public String getWelfare() {
		return welfare;
	}
	/**
	 * @param welfare 要设置的 welfare
	 */
	public void setWelfare(String welfare) {
		this.welfare = welfare;
	}
	/**
	 * @return industry
	 */
	public String getIndustry() {
		return industry;
	}
	/**
	 * @param industry 要设置的 industry
	 */
	public void setIndustry(String industry) {
		this.industry = industry;
	}
	/* （非 Javadoc）
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((capacity == null) ? 0 : capacity.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + id;
		result = prime * result + ((industry == null) ? 0 : industry.hashCode());
		result = prime * result + ((position == null) ? 0 : position.hashCode());
		result = prime * result + salaryLeast;
		result = prime * result + salaryMost;
		result = prime * result + ((welfare == null) ? 0 : welfare.hashCode());
		result = prime * result + workYear;
		return result;
	}
	/* （非 Javadoc）
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		TagInfo other = (TagInfo) obj;
		if (capacity == null) {
			if (other.capacity != null) {
				return false;
			}
		} else if (!capacity.equals(other.capacity)) {
			return false;
		}
		if (city == null) {
			if (other.city != null) {
				return false;
			}
		} else if (!city.equals(other.city)) {
			return false;
		}
		if (id != other.id) {
			return false;
		}
		if (industry == null) {
			if (other.industry != null) {
				return false;
			}
		} else if (!industry.equals(other.industry)) {
			return false;
		}
		if (position == null) {
			if (other.position != null) {
				return false;
			}
		} else if (!position.equals(other.position)) {
			return false;
		}
		if (salaryLeast != other.salaryLeast) {
			return false;
		}
		if (salaryMost != other.salaryMost) {
			return false;
		}
		if (welfare == null) {
			if (other.welfare != null) {
				return false;
			}
		} else if (!welfare.equals(other.welfare)) {
			return false;
		}
		if (workYear != other.workYear) {
			return false;
		}
		return true;
	}
	/* （非 Javadoc）
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TagInfo [id=" + id + ", workYear=" + workYear + ", salaryLeast=" + salaryLeast + ", salaryMost="
				+ salaryMost + ", city=" + city + ", capacity=" + capacity + ", position=" + position + ", welfare="
				+ welfare + ", industry=" + industry + "]";
	}
}
	
	