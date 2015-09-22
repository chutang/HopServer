package com.chu.Threads;

import org.apache.log4j.Logger;

public class TestThreads {
	static Logger logger = Logger.getLogger(TestThreads.class);
	private static void threadMessage(String info){
		String threadName = Thread.currentThread().getName();
		logger.info("thread name is :"+ threadName+" : "+info);
	}
	
	private static class MessageLoop implements Runnable {
		public void run(){
			String inInfo[] = {
					"Info 1 test",
					"Info 2 test",
					"Info 3 test",
					"Info 4 test"
			};
			
			for (int i = 0 ; i < inInfo.length-1; i++){
				try {
					Thread.sleep(4000);
					threadMessage(inInfo[i]);
				} catch (InterruptedException e) {
					threadMessage("Not done yet");
				}
				//logger.info("inInfo sequence is "+String.valueOf(i)+" , value is "+inInfo[i]);
			}
		}
	}
	
	public static void main(String arg []) throws InterruptedException{
		long patience = 1000*60*3;
		threadMessage("Starting MessageLoop thread");
		long startTime = System.currentTimeMillis();
		Thread t = new Thread(new MessageLoop());
		t.start();
//		Thread t1 = new Thread(new MessageLoop());
//		t1.start();
		
		threadMessage("Waiting for MessageLoop finish");
		
		while(t.isAlive()){
			threadMessage("Still waiting...");
			t.join(1000);
			if(((System.currentTimeMillis() - startTime) > patience) && t.isAlive()){
				threadMessage("Tired of waiting");
				t.interrupt();
				t.join();
			}
		}
		
		threadMessage("All finished");
	}

}
