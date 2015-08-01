package com.my.logger;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//private final static Logger LOG = LoggerFactory.getLogger(ResolverResource.class);
public class ParseLaunch{

	//static Properties properties ;
	
	//initialize if null
	
	public static void parseLogFile() throws IOException {
		
		Properties properties = new Properties();
		String propertiesFile = "customlog4j.properties";
		
		InputStream inputstream =  new ParseLaunch().getClass().getClassLoader().getResourceAsStream(propertiesFile);
		if(inputstream!=null){
			properties.load(inputstream);
		}else{
			throw new FileNotFoundException("file "+propertiesFile+" not found");
		}
		
		//System.out.println(properties.get("appenders"));
		//System.out.println(properties.get("level"));
		
		String[] appenders = properties.get("appenders").toString().split(",");
		
		for(String s:appenders){
			ThreadPool.getThread(s);
		}	
	}
	
	public static void main(String[] args) throws IOException{
		ParseLaunch.parseLogFile();
	}
	
	
}
