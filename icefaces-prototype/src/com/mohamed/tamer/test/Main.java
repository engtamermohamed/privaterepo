package com.mohamed.tamer.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mohamed.tamer.hibernate.dao.DealDao;
import com.mohamed.tamer.hibernate.dao.DealItemDao;
import com.mohamed.tamer.hibernate.dao.ProductDao;
import com.mohamed.tamer.hibernate.model.Deal;
import com.mohamed.tamer.hibernate.model.DealItem;
import com.mohamed.tamer.hibernate.model.Product;

public class Main
{
	public static void main(String[] args)
	{
//		Deal deal = new Deal();
//		deal.setDealDateTime(new Date());
//		
//		List<DealItem> dealItems = new ArrayList<DealItem>();
//		
//		DealItem dealItem1 = new DealItem();
//		dealItem1.setDeal(deal);
//		dealItem1.setQuantity(1);
//		
//		DealItem dealItem2 = new DealItem();
//		dealItem2.setDeal(deal);
//		dealItem2.setQuantity(2);
//		
//		DealItem dealItem3 = new DealItem();
//		dealItem3.setDeal(deal);
//		dealItem3.setQuantity(3);
//		
//		dealItems.add(dealItem1);
//		dealItems.add(dealItem2);
//		dealItems.add(dealItem3);
//		
//		deal.setDealItems(dealItems);
//		
//		DealDao.save(deal);
		
		Deal deal = DealDao.findById(2L);
		System.out.println(deal);
		
		List<DealItem> dealItems = DealItemDao.findByDeal(deal);
		for(DealItem dealItem : dealItems)
		{
			System.out.println(dealItem);
		}// end for
		
		deal.getDealItems().remove(2);
		
		deal = DealDao.merge(deal);
		
		System.out.println(deal);
		
//		Product product1 = new Product();
//		product1.setProductName("Product 1");
//		
//		Product product2 = new Product();
//		product2.setProductName("Product 2");
//		
//		ProductDao.save(product1);
//		ProductDao.save(product2);
//		
//		List<Product> products = ProductDao.findAll();
//		for(Product product : products)
//		{
//			System.out.println(product);
//		}// end for
	}// end of main method
	
}// end of class Main 
