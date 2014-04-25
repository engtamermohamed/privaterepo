package com.mohamed.tamer.hibernate.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.mohamed.tamer.security.Security;

@Entity
@Table(name = "UI_USER")
public class UiUser extends Security
{
	@Id
	@GeneratedValue
	@Column(name = "UI_USER_ID")
	private Long uiUserId;

	@Column(name = "UI_USER_NAME")
	private String uiUserName;

	@Column(name = "UI_USER_PASSWORD")
	private String uiUserPassword;

	@OneToMany(mappedBy = "uiUser", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<UiUserRole> uiUserRoles;

	@Column(name = "UI_USER_ACTIVE")
	private boolean uiUserActive;

	public Long getUiUserId()
	{
		return uiUserId;
	}

	public void setUiUserId(Long uiUserId)
	{
		this.uiUserId = uiUserId;
	}

	public String getUiUserName()
	{
		return uiUserName;
	}

	public void setUiUserName(String uiUserName)
	{
		this.uiUserName = uiUserName;
	}

	public String getUiUserPassword()
	{
		return decrypt(uiUserPassword);
	}

	public void setUiUserPassword(String uiUserPassword)
	{
		this.uiUserPassword = encrypt(uiUserPassword);
	}

	public List<UiUserRole> getUiUserRoles()
	{
		return uiUserRoles;
	}

	public void setUiUserRoles(List<UiUserRole> uiUserRoles)
	{
		this.uiUserRoles = uiUserRoles;
	}

	public boolean isUiUserActive()
	{
		return uiUserActive;
	}

	public void setUiUserActive(boolean uiUserActive)
	{
		this.uiUserActive = uiUserActive;
	}

	@Override
	public String toString()
	{
		return "UiUser [uiUserId=" + uiUserId + ", uiUserName=" + uiUserName + ", uiUserActive=" + uiUserActive + "]";
	}

}// end of class UiUser
