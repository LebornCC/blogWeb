package com.bean;

public class People {
	//userId账号，userName昵称，userPwd密码
	int userId;
	String userPwd;
	public People() {
		super();
		// TODO Auto-generated constructor stub
	}
	public People(int userId, String userPwd) {
		super();
		this.userId = userId;
		this.userPwd = userPwd;
	}
	public int getId() {
		return userId;
	}
	public void setId(int userId) {
		this.userId = userId;
	}
	public String getPwd() {
		return userPwd;
	}
	public void setPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	@Override
	public String toString() {
        String returnValue = "{\"code\":\"1\",\"userId\":\""+userId+"\",\"userPwd\":\""+userPwd+"\"}";
	    return returnValue;
	}

}
