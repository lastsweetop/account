package com.eshore.account.persist;

public class Account {
	private String id;
	private String name;
	private String email;
	private String password;
	private boolean activated;

	/**
	 * getId:(这里用一句话描述这个方法的作用). <br/>
	 * @author wudongdong
	 * @return id String
	 * @since JDK 1.6
	 */
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

	public String getPassword() {
		return password;
	}

	/**
	 * setPassword:(这里用一句话描述这个方法的作用). <br/>
	 * @author wudongdong
	 * @param password
	 * @since JDK 1.6
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * isActivated:(这里用一句话描述这个方法的作用). <br/>
	 * @author wudongdong
	 * @return boolean
	 */
	public final boolean isActivated() {
		return activated;
	}

	/**
	 * setActivated:(这里用一句话描述这个方法的作用). <br/>
	 * @author wudongdong
	 * @param newActivated boolean
	 * @since JDK 1.6
	 */
	public final void setActivated(final boolean newActivated) {
		this.activated = newActivated;
	}

}
