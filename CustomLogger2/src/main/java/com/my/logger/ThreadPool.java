package com.my.logger;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {

	static ExecutorService executorService;
	
	public static void initalisePool(){
	
		 executorService = Executors.newFixedThreadPool(10);
	}
	
	public static void getThread(String appender) {
	
	initalisePool();

	executorService.execute(new Runnable() {
	    public void run() {
//	    	LoggerFactory
	    }
	});

  }

}
