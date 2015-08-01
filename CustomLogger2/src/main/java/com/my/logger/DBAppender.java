package com.my.logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DBAppender {

	static volatile ArrayList<String> columnNames;
	  final static String hiveDriverName = "com.mysql.jdbc.Driver";
	  private static DBAppender manager = new DBAppender();
	  Connection connection =null;
	  Statement statement = null;
			  
	  private DBAppender() {
		  try {
			initializeConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
		}
	  }
	  
	  public static DBAppender getInstance() {
		  return manager;
	  }
	  
	  public void initializeConnection() throws Exception {
		try{
		     Class.forName(hiveDriverName);
		} catch (ClassNotFoundException e) {
		       // TODO Auto-generated catch block
		       	
	    }
		    
		final String DB_URL = null;
		final String USER = null;
		final String PASS = null;
		   
		//replace "hive" here with the name of the user the queries should run as
		connection = DriverManager.getConnection(DB_URL, USER, PASS);
		statement = connection.createStatement();
	  }

	  public static void initializeColumnNames() {
	    if(DBAppender.columnNames==null)
	    	DBAppender.columnNames = new ArrayList<String>();
	  }
	  
	  public ArrayList<String> getColumnsForTable(String tableName) throws Exception {
		if(connection==null)
		  initializeConnection();
		  
		ArrayList<String> columns = new ArrayList<String>();
		String sql = "describe ".concat(tableName);
	    ResultSet resultSet = statement.executeQuery(sql);
	    StringBuffer buffer = new StringBuffer();
	      
	    while (resultSet.next()) {
	      buffer.append(resultSet.getString(1));
	      columns.add(buffer.toString());
	      buffer.delete(0, buffer.length());
	    }
	      return columns;
	   }
	  
	  
	  public void populateColumns(ArrayList<String> tables) throws Exception {
		if(connection==null)
		  initializeConnection();
		  
		DBAppender.columnNames = new ArrayList<String>();
	    
	     for(String table:tables){
	     String sql = "describe ".concat(table);
	     ResultSet resultSet = statement.executeQuery(sql);
	     while (resultSet.next()) {
	         
	       StringBuffer buffer = new StringBuffer();
	       buffer.append(table);
	       buffer.append(".");
	       buffer.append(resultSet.getString(1));
	       columnNames.add(buffer.toString());
	       buffer.delete(0, buffer.length());
	       }
	     }    
	  }
}
