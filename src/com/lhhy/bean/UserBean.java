package com.lhhy.bean;

public class UserBean {

	private String userId;
	private String userName;
	private String password;
	private String roleName;
	private String phone;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public UserBean(String userId, String userName, String password, String roleName, String phone) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.roleName = roleName;
		this.phone = phone;
	}
	public UserBean() {
		super();
	}

}
