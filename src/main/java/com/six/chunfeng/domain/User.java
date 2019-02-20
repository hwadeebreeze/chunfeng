package com.six.chunfeng.domain;

public class User {
	
	private int id;
	private String name;
	private String inform;
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
	 * @return inform
	 */
	public String getInform() {
		return inform;
	}
	/**
	 * @param inform 要设置的 inform
	 */
	public void setInform(String inform) {
		this.inform = inform;
	}
	/* （非 Javadoc）
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", inform=" + inform + "]";
	}
	
	
}
