package com.six.chunfeng.domain;

public class JobInfo {
	private Integer id;
	private String url;
	private String title;
	private String education;
	private Integer workYear;
	private Integer ageMost;
	private String city;
	private String content;
	private Integer salaryMost;
	private Integer salaryLeast;
	private Integer ageLeast;
	private String welfare;
	private String capacity;
	private Integer companyId;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public Integer getWorkYear() {
		return workYear;
	}
	public void setWorkYear(Integer workYear) {
		this.workYear = workYear;
	}
	public Integer getAgeMost() {
		return ageMost;
	}
	public void setAgeMost(Integer ageMost) {
		this.ageMost = ageMost;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getSalaryMost() {
		return salaryMost;
	}
	public void setSalaryMost(Integer salaryMost) {
		this.salaryMost = salaryMost;
	}
	public Integer getSalaryLeast() {
		return salaryLeast;
	}
	public void setSalaryLeast(Integer salaryLeast) {
		this.salaryLeast = salaryLeast;
	}
	public Integer getAgeLeast() {
		return ageLeast;
	}
	public void setAgeLeast(Integer ageLeast) {
		this.ageLeast = ageLeast;
	}
	public String getWelfare() {
		return welfare;
	}
	public void setWelfare(String welfare) {
		this.welfare = welfare;
	}
	public String getCapacity() {
		return capacity;
	}
	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}
	public Integer getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((ageLeast == null) ? 0 : ageLeast.hashCode());
		result = prime * result + ((ageMost == null) ? 0 : ageMost.hashCode());
		result = prime * result
				+ ((capacity == null) ? 0 : capacity.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result
				+ ((companyId == null) ? 0 : companyId.hashCode());
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result
				+ ((education == null) ? 0 : education.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((salaryLeast == null) ? 0 : salaryLeast.hashCode());
		result = prime * result
				+ ((salaryMost == null) ? 0 : salaryMost.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((url == null) ? 0 : url.hashCode());
		result = prime * result + ((welfare == null) ? 0 : welfare.hashCode());
		result = prime * result
				+ ((workYear == null) ? 0 : workYear.hashCode());
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
		JobInfo other = (JobInfo) obj;
		if (ageLeast == null) {
			if (other.ageLeast != null)
				return false;
		} else if (!ageLeast.equals(other.ageLeast))
			return false;
		if (ageMost == null) {
			if (other.ageMost != null)
				return false;
		} else if (!ageMost.equals(other.ageMost))
			return false;
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
		if (companyId == null) {
			if (other.companyId != null)
				return false;
		} else if (!companyId.equals(other.companyId))
			return false;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (education == null) {
			if (other.education != null)
				return false;
		} else if (!education.equals(other.education))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (salaryLeast == null) {
			if (other.salaryLeast != null)
				return false;
		} else if (!salaryLeast.equals(other.salaryLeast))
			return false;
		if (salaryMost == null) {
			if (other.salaryMost != null)
				return false;
		} else if (!salaryMost.equals(other.salaryMost))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		if (welfare == null) {
			if (other.welfare != null)
				return false;
		} else if (!welfare.equals(other.welfare))
			return false;
		if (workYear == null) {
			if (other.workYear != null)
				return false;
		} else if (!workYear.equals(other.workYear))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "JobInfo [id=" + id + ", url=" + url + ", title=" + title
				+ ", education=" + education + ", workYear=" + workYear
				+ ", ageMost=" + ageMost + ", city=" + city + ", content="
				+ content + ", salaryMost=" + salaryMost + ", salaryLeast="
				+ salaryLeast + ", ageLeast=" + ageLeast + ", welfare="
				+ welfare + ", capacity=" + capacity + ", company_id="
				+ companyId + "]";
	}
	

}
