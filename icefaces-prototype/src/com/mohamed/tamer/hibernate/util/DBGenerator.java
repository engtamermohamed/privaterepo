package com.mohamed.tamer.hibernate.util;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class DBGenerator
{
	public static void main(String[] args)
	{
		Configuration configuration = new Configuration().configure();

		SchemaExport schemaExport = new SchemaExport(configuration);
		schemaExport.setDelimiter(";");
		
		// un-comment this line to write database creation script 'ddl' to file
//		schemaExport.setOutputFile(String.format("%s_%s.%s ", new Object[] {"ddl", "mysql", "sql" }));
		boolean consolePrint = true;
		boolean exportInDatabase = true;
		schemaExport.create(consolePrint, exportInDatabase);
	}// end of main method
	
}// end of class DBGenerator
