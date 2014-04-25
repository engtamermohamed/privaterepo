package com.mohamed.tamer.hibernate.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "DEAL")
public class Deal
{
	@Id
	@GeneratedValue
	@Column(name = "DEAL_ID")
	private Long dealId;
	
	@Column(name = "DEAL_DATE_TIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dealDateTime;
	
	@OneToMany(mappedBy="deal",cascade=CascadeType.ALL,orphanRemoval=true)
	private List<DealItem> dealItems;

	public Long getDealId()
	{
		return dealId;
	}

	public void setDealId(Long dealId)
	{
		this.dealId = dealId;
	}

	public Date getDealDateTime()
	{
		return dealDateTime;
	}

	public void setDealDateTime(Date dealDateTime)
	{
		this.dealDateTime = dealDateTime;
	}

	public List<DealItem> getDealItems()
	{
		return dealItems;
	}

	public void setDealItems(List<DealItem> dealItems)
	{
		this.dealItems = dealItems;
	}

	@Override
	public String toString()
	{
		return "Deal [dealId=" + dealId + ", dealDateTime=" + dealDateTime + "]";
	}
	
}// end of class Deal
