package com.training.models;

public class Admin {

	private int adminId;
	private String adminFullName;
	private String adminUserName;
	private String adminGender;
	
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(int adminId, String adminFullName, String adminUserName, String adminGender) {
		super();
		this.adminId = adminId;
		this.adminFullName = adminFullName;
		this.adminUserName = adminUserName;
		this.adminGender = adminGender;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getAdminFullName() {
		return adminFullName;
	}

	public void setAdminFullName(String adminFullName) {
		this.adminFullName = adminFullName;
	}

	public String getAdminUserName() {
		return adminUserName;
	}

	public void setAdminUserName(String adminUserName) {
		this.adminUserName = adminUserName;
	}

	public String getAdminGender() {
		return adminGender;
	}

	public void setAdminGender(String adminGender) {
		this.adminGender = adminGender;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adminFullName == null) ? 0 : adminFullName.hashCode());
		result = prime * result + ((adminGender == null) ? 0 : adminGender.hashCode());
		result = prime * result + adminId;
		result = prime * result + ((adminUserName == null) ? 0 : adminUserName.hashCode());
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
		Admin other = (Admin) obj;
		if (adminFullName == null) {
			if (other.adminFullName != null)
				return false;
		} else if (!adminFullName.equals(other.adminFullName))
			return false;
		if (adminGender == null) {
			if (other.adminGender != null)
				return false;
		} else if (!adminGender.equals(other.adminGender))
			return false;
		if (adminId != other.adminId)
			return false;
		if (adminUserName == null) {
			if (other.adminUserName != null)
				return false;
		} else if (!adminUserName.equals(other.adminUserName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminFullName=" + adminFullName + ", adminUserName=" + adminUserName
				+ ", adminGender=" + adminGender + "]";
	}
	
	
	
}
