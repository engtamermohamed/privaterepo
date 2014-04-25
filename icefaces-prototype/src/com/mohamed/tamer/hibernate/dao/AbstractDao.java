package com.mohamed.tamer.hibernate.dao;

import org.hibernate.Session;

import com.mohamed.tamer.hibernate.util.HibernateUtil;

public abstract class AbstractDao
{
	protected static Session openSession()
	{
		return HibernateUtil.getSessionFactory().openSession();
	}// end of method openSession
	
}// end of class AbstractDao
