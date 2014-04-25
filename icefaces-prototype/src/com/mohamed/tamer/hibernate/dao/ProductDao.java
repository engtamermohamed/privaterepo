package com.mohamed.tamer.hibernate.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mohamed.tamer.hibernate.model.Product;

public class ProductDao extends AbstractDao
{
	@SuppressWarnings("unchecked")
	public static List<Product> findAll()
	{
		List<Product> products = null;
		Session session = openSession();
		Transaction transaction = null;
		
		try
		{
			transaction = session.beginTransaction();
			products = (List<Product>) session.createQuery("FROM Product").list();
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
		
		return products;
	}// end of method findAll
	
	public static void save(Product product)
	{
		Session session = openSession();
		Transaction transaction = null;

		try
		{
			transaction = session.beginTransaction();
			session.save(product);
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
	
}// end of class ProductDao
