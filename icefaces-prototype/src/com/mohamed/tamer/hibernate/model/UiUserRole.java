package com.mohamed.tamer.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "UI_USER_ROLE")
public class UiUserRole
{
	@Id
	@GeneratedValue
	@Column(name = "UI_USER_ROLE_ID")
	private Long uiUserRoleId;
	
	@ManyToOne
	@JoinColumn(name = "UI_USER_ID")
	private UiUser uiUser;
	
	@ManyToOne
	@JoinColumn(name = "UI_ROLE_ID")
	private UiRole uiRole;

	public Long getUiUserRoleId()
	{
		return uiUserRoleId;
	}

	public void setUiUserRoleId(Long uiUserRoleId)
	{
		this.uiUserRoleId = uiUserRoleId;
	}

	public UiUser getUiUser()
	{
		return uiUser;
	}

	public void setUiUser(UiUser uiUser)
	{
		this.uiUser = uiUser;
	}

	public UiRole getUiRole()
	{
		return uiRole;
	}

	public void setUiRole(UiRole uiRole)
	{
		this.uiRole = uiRole;
	}

	@Override
	public String toString()
	{
		return "UiUserRole [uiUserRoleId=" + uiUserRoleId + ", uiUser=" + uiUser + ", uiRole=" + uiRole + "]";
	}
	
}// end of class UiUserRole
