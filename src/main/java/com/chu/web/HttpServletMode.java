package com.chu.web;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.apache.log4j.Logger;

public class HttpServletMode extends HttpServlet {
	final Logger logger = Logger.getLogger(HttpServletMode.class);
	private String info = "default value";

	public HttpServletMode() {

	}

	public HttpServletMode(String s) {
		this.info = s;

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		String cmd = request.getParameter("cmd");
		String name = request.getParameter("name");
		String passwd = request.getParameter("passwd");
		logger.info("cmd="+cmd+" , name="+name+" , passwd"+passwd);

	}

}
