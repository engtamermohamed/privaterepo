package com.mohamed.tamer.hibernate.util;

import org.hibernate.dialect.MySQL5InnoDBDialect;

public class Mysql5Dialect extends MySQL5InnoDBDialect
{
	@Override
	public String getTableTypeString()
	{
		return " ENGINE=InnoDB DEFAULT CHARSET=utf8";
	}// end of method getTableTypeString
	
}// end of class Mysql5Dialect