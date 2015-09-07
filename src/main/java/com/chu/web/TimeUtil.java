package com.chu.web;

import java.util.Date;

import org.apache.log4j.Logger;

public class TimeUtil implements Runnable{
	Thread t;
	static long tms = 1;
	public TimeUtil(long tm){
		TimeUtil.tms = tm;
		t=new Thread(this);
		t.start();
		
	}
	public static void timeCheck(){
		final Logger logger = Logger.getLogger(TimeUtil.class);
		Long time = (long) (tms*1000);
		long stat = new Date().getTime();
		long end = stat+time;
		while(true){
			long now = new Date().getTime();
			time=end-now;
			if(time>0){
				logger.info((long)time/1000);
			}else{
				break;
				}
			try{
				Thread.sleep(3000);
			}catch (Exception e){
				e.printStackTrace();
			}
		}
		
	}

	public void run() {
		timeCheck();
		
	}

}
