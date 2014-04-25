package com.mohamed.tamer.hibernate.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mohamed.tamer.hibernate.model.Deal;
import com.mohamed.tamer.hibernate.model.DealItem;

public class DealItemDao extends AbstractDao
{
	@SuppressWarnings("unchecked")
	public static List<DealItem> findByDeal(Deal deal)
	{
		List<DealItem> dealItems = null;
		Session session = openSession();
		Transaction transaction = null;
		
		String hqlQuery = "FROM DealItem dealItem WHERE dealItem.deal.dealId = :dealId";
		
		try
		{
			transaction = session.beginTransaction();
			Query query = session.createQuery(hqlQuery);
			query.setParameter("dealId", deal.getDealId());
			
			dealItems = (List<DealItem>) query.list();
			for(DealItem dealItem : dealItems)
			{
				dealItem.setDeal(deal);
			}// end for
			
			deal.setDealItems(dealItems);
		}// end try
		catch (HibernateException hibernateException)
		{
			if (transaction != null)
			{
				transaction.rollback();
			}// end if
			
			hibernateException.printStackTrace();
		}// end catch
		catch (Exception e)
		{
			e.printStackTrace();
		}// end catch
		finally
		{
			session.close();
		}// end finally
		
		return dealItems;
	}// end of method findByDeal
	
}// end of class DealItemDao
