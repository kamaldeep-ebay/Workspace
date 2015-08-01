package com.my.logger;

import java.io.IOException;

public class FileAppender implements LoggerInterface{

	
	private static FileAppender manager = new FileAppender();
	  
	  private FileAppender() {
		  try {
			initializeConnection();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//LOG.error("Error in initializing HDFS / Filesystem API connection");
			//throw new AttributeResolveException("Could not instantiate Filesytem API");
		}
	  }
	  
	  public static FileAppender getInstance() {
		  return manager;
	  }
	  
	  private void initializeConnection() throws IOException {
	    
	  }

	public void warn(String message) {
		// TODO Auto-generated method stub
		String newmessage = "WARN".concat(message);
	}

	public void info(String message) {
		// TODO Auto-generated method stub
		
	}


}
