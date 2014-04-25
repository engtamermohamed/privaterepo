package com.mohamed.tamer.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "DEAL_ITEM")
public class DealItem
{
	@Id
	@GeneratedValue
	@Column(name = "DEAL_ITEM_ID")
	private Long dealItemId;

	@ManyToOne
	@JoinColumn(name = "DEAL_ID")
	private Deal deal;
	
	@ManyToOne
	@JoinColumn(name = "PRODUCT_ID")
	private Product product;
	
	@Column(name = "QUANTITY")
	private Integer quantity;

	public Long getDealItemId()
	{
		return dealItemId;
	}

	public void setDealItemId(Long dealItemId)
	{
		this.dealItemId = dealItemId;
	}

	public Deal getDeal()
	{
		return deal;
	}

	public void setDeal(Deal deal)
	{
		this.deal = deal;
	}

	public Product getProduct()
	{
		return product;
	}

	public void setProduct(Product product)
	{
		this.product = product;
	}

	public Integer getQuantity()
	{
		return quantity;
	}

	public void setQuantity(Integer quantity)
	{
		this.quantity = quantity;
	}

	@Override
	public String toString()
	{
		return "DealItem [dealItemId=" + dealItemId + ", deal=" + deal + ", product=" + product + ", quantity="
				+ quantity + "]";
	}
	
}// end of class TransactionItem
