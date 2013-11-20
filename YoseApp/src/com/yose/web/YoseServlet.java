package com.yose.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Servlet implementation class YoseServlet
 */
@WebServlet({"/YoseServlet", "/yose", "/ping"})
public class YoseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			execute(response);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	private void execute(HttpServletResponse response) throws IOException, JSONException {
		response.setContentType("application/json");
		
		JSONObject json = new JSONObject();
		json.put("alive", true);
		response.getWriter().print(json);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			execute(response);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

}
