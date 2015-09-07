package com.chu.web;

public class Webmain {
	public static void main (String args []) throws Exception{
		
		long times=10;
		new TimeUtil(times);
		JettyService test = new JettyService(true,times);
		test.startJettyService();
		
	}

}
 