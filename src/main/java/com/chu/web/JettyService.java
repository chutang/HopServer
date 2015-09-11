package com.chu.web;

import org.apache.log4j.Logger;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class JettyService {
	final Logger logger = Logger.getLogger(JettyService.class);
	private boolean checkUrl = false;
	private long time = 1*1000;

	public JettyService() {

	}

	public JettyService(boolean IsCheckUrl) {
		this.checkUrl = IsCheckUrl;
	}
	
	public JettyService(boolean IsCheckUrl,long times){
		this.checkUrl = IsCheckUrl;
		this.time=times*1000;
	}
	

	public void startJettyService() throws Exception {
		Server server = new Server(8080);
		ServletContextHandler contexthandler = new ServletContextHandler(
				ServletContextHandler.SESSIONS);
		contexthandler.setContextPath("/");
		server.setHandler(contexthandler);
		contexthandler.addServlet(new ServletHolder(new HttpServletMode()), "");
		contexthandler.addServlet(
				new ServletHolder(new HttpServletMode("Test")), "/a");
		server.start();
		logger.info(server.getURI());
		logger.info(server.getURI()+"?cmd=&passwd=&name");
		if (checkUrl) {
			logger.info("Start to open url");
			CheckUrl.OpenLocal();
		}
		Thread.sleep(time);
		
		server.stop();

	}

}
