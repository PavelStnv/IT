package models;

import java.util.Objects;

public class User {
	
	private String strName;
	private String strUsername;
	private String strPassword;
	private String jobtitle;
	private String description;
	private String email;
	private String phone;
	private String profskills;
	private String personal_skills;
	
	
	public User(String strName, String strUsername, String strPassword) {
		this.strName = strName;
		this.strUsername = strUsername;
		this.strPassword = strPassword;
	}
	
	public String getStrName() {
		return strName;
	}
	
	public void setStrName(String strName) {
		this.strName = strName;
	}
	
	public String getStrUsername() {
		return strUsername;
	}
	
	public void setStrUsername(String strUsername) {
		this.strUsername = strUsername;
	}
	
	public String getStrPassword() {
		return strPassword;
	}
	
	public void setStrPassword(String strPassword) {
		this.strPassword = strPassword;
	}

	@Override
	public int hashCode() {
		return Objects.hash(strUsername);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(strUsername, other.strUsername);
	}
	
	
}
