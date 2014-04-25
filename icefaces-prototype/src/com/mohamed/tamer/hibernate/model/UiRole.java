package com.mohamed.tamer.hibernate.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "UI_ROLE")
public class UiRole
{
	@Id
	@GeneratedValue
	@Column(name = "UI_ROLE_ID")
	private Long uiRoleId;
	
	@Column(name = "UI_ROLE_NAME")
	private String uiRoleName;
	
	@Column(name = "UI_ROLE_ACTIVE")
	private boolean uiRoleActive;
	
	@OneToMany(mappedBy="uiRole",cascade=CascadeType.ALL,orphanRemoval=true)
	private List<UiUserRole> uiUserRoles;

	public Long getUiRoleId()
	{
		return uiRoleId;
	}

	public void setUiRoleId(Long uiRoleId)
	{
		this.uiRoleId = uiRoleId;
	}

	public String getUiRoleName()
	{
		return uiRoleName;
	}

	public void setUiRoleName(String uiRoleName)
	{
		this.uiRoleName = uiRoleName;
	}

	public boolean isUiRoleActive()
	{
		return uiRoleActive;
	}

	public void setUiRoleActive(boolean uiRoleActive)
	{
		this.uiRoleActive = uiRoleActive;
	}

	public List<UiUserRole> getUiUserRoles()
	{
		return uiUserRoles;
	}

	public void setUiUserRoles(List<UiUserRole> uiUserRoles)
	{
		this.uiUserRoles = uiUserRoles;
	}

	@Override
	public String toString()
	{
		return "UiRole [uiRoleId=" + uiRoleId + ", uiRoleName=" + uiRoleName + ", uiRoleActive=" + uiRoleActive + "]";
	}
}// end of class UiRole
