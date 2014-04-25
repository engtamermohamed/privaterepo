package com.mohamed.tamer.hibernate.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mohamed.tamer.hibernate.model.Deal;

public class DealDao extends AbstractDao
{
	public static Deal findById(Long id)
	{
		Deal deal = null;
		Session session = openSession();
		Transaction transaction = null;
		String hqlQuery = "FROM Deal deal WHERE deal.dealId = :dealId";
		
		try
		{
			transaction = session.beginTransaction();
			Query query = session.createQuery(hqlQuery);
			query.setParameter("dealId", id);
			
			deal = (Deal) query.uniqueResult();
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
		
		return deal;
	}// end of method findById
	
	public static void save(Deal deal)
	{
		Session session = openSession();
		Transaction transaction = null;
		
		try
		{
			transaction = session.beginTransaction();
			session.save(deal);
			transaction.commit();
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
	}// end of method save
	
	public static void update(Deal deal)
	{
		Session session = openSession();
		Transaction transaction = null;
		
		try
		{
			transaction = session.beginTransaction();
			session.update(deal);
			transaction.commit();
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
	}// end of method update
	
	public static Deal merge(Deal deal)
	{
		Deal deal_ = null;
		Session session = openSession();
		Transaction transaction = null;

		try
		{
			transaction = session.beginTransaction();
			deal_ = (Deal) session.merge(deal);
			transaction.commit();
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
		
		return deal_;
	}// end of method merge
	
}// end of class TransactionDao
