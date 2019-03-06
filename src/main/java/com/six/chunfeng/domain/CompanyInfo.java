package com.six.chunfeng.domain;

public class CompanyInfo {
	private int id;
	private String name;
	private String size;
	private String address;
	private String info;
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
	 * @return size
	 */
	public String getSize() {
		return size;
	}
	/**
	 * @param size 要设置的 size
	 */
	public void setSize(String size) {
		this.size = size;
	}
	/**
	 * @return address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address 要设置的 address
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return info
	 */
	public String getInfo() {
		return info;
	}
	/**
	 * @param info 要设置的 info
	 */
	public void setInfo(String info) {
		this.info = info;
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
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + id;
		result = prime * result + ((industry == null) ? 0 : industry.hashCode());
		result = prime * result + ((info == null) ? 0 : info.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((size == null) ? 0 : size.hashCode());
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
		CompanyInfo other = (CompanyInfo) obj;
		if (address == null) {
			if (other.address != null) {
				return false;
			}
		} else if (!address.equals(other.address)) {
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
		if (info == null) {
			if (other.info != null) {
				return false;
			}
		} else if (!info.equals(other.info)) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (size == null) {
			if (other.size != null) {
				return false;
			}
		} else if (!size.equals(other.size)) {
			return false;
		}
		return true;
	}
	/* （非 Javadoc）
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CompanyInfo [id=" + id + ", name=" + name + ", size=" + size + ", address=" + address + ", info=" + info
				+ ", industry=" + industry + "]";
	}
	
	
}
