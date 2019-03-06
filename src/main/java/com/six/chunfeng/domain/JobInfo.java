package com.six.chunfeng.domain;

public class JobInfo {
	private int id;
	private String url;
	private String title;
	private String education;
	private int workYear;
	private int ageMost;
	private String city;
	private String content;
	private int salaryMost;
	private int salaryLeast;
	private int ageLeast;
	private String welfare;
	private String capacity;
	private CompanyInfo company;
	
	
	/**
	 * @return company
	 */
	public CompanyInfo getCompany() {
		return company;
	}
	/**
	 * @param company 要设置的 company
	 */
	public void setCompany(CompanyInfo company) {
		this.company = company;
	}
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
	 * @return url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * @param url 要设置的 url
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * @return title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title 要设置的 title
	 */
	public void setTitle(String title) {
		this.title = title;
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
	 * @return ageMost
	 */
	public int getAgeMost() {
		return ageMost;
	}
	/**
	 * @param ageMost 要设置的 ageMost
	 */
	public void setAgeMost(int ageMost) {
		this.ageMost = ageMost;
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
	 * @return content
	 */
	public String getContent() {
		return content;
	}
	/**
	 * @param content 要设置的 content
	 */
	public void setContent(String content) {
		this.content = content;
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
	 * @return ageLeast
	 */
	public int getAgeLeast() {
		return ageLeast;
	}
	/**
	 * @param ageLeast 要设置的 ageLeast
	 */
	public void setAgeLeast(int ageLeast) {
		this.ageLeast = ageLeast;
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
	/* （非 Javadoc）
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ageLeast;
		result = prime * result + ageMost;
		result = prime * result + ((capacity == null) ? 0 : capacity.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((company == null) ? 0 : company.hashCode());
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((education == null) ? 0 : education.hashCode());
		result = prime * result + id;
		result = prime * result + salaryLeast;
		result = prime * result + salaryMost;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((url == null) ? 0 : url.hashCode());
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
		JobInfo other = (JobInfo) obj;
		if (ageLeast != other.ageLeast) {
			return false;
		}
		if (ageMost != other.ageMost) {
			return false;
		}
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
		if (company == null) {
			if (other.company != null) {
				return false;
			}
		} else if (!company.equals(other.company)) {
			return false;
		}
		if (content == null) {
			if (other.content != null) {
				return false;
			}
		} else if (!content.equals(other.content)) {
			return false;
		}
		if (education == null) {
			if (other.education != null) {
				return false;
			}
		} else if (!education.equals(other.education)) {
			return false;
		}
		if (id != other.id) {
			return false;
		}
		if (salaryLeast != other.salaryLeast) {
			return false;
		}
		if (salaryMost != other.salaryMost) {
			return false;
		}
		if (title == null) {
			if (other.title != null) {
				return false;
			}
		} else if (!title.equals(other.title)) {
			return false;
		}
		if (url == null) {
			if (other.url != null) {
				return false;
			}
		} else if (!url.equals(other.url)) {
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
		return "JobInfo [id=" + id + ", url=" + url + ", title=" + title + ", education=" + education + ", workYear="
				+ workYear + ", ageMost=" + ageMost + ", city=" + city + ", content=" + content + ", salaryMost="
				+ salaryMost + ", salaryLeast=" + salaryLeast + ", ageLeast=" + ageLeast + ", welfare=" + welfare
				+ ", capacity=" + capacity + ", company=" + company + "]";
	}
	
	
	
}
