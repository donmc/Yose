package com.yose.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.yose.math.PrimeFactors;

/**
 * Servlet implementation class PrimeFactors
 */
@WebServlet({ "/PrimeFactors", "/primeFactors" })
public class PrimeFactorsServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String returnString = null;
		try {
			String[] numbers = request.getParameterValues("number");
			
			if(numbers == null) {
				
				returnString = "empty";
				
			} else if (numbers.length > 1) {
				
				for (String number : numbers) {
					JSONArray jsonArray = new JSONArray();	
					JSONObject jsonObject = createJsonObject(number);
					jsonArray.put(jsonObject);
					returnString = jsonArray.toString();
				}
			} else {
				returnString = createJsonObject(numbers[0]).toString();
			
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		response.setContentType("application/json");
		response.getWriter().print(returnString);
	}

	private JSONObject createJsonObject(String number) throws JSONException {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("number", number);
		
		PrimeFactors prime = new PrimeFactors();
		
		List<Integer> decomposition;
		try {
			decomposition = prime.calculateFor(Integer.parseInt(number));
			jsonObject.put("decomposition", decomposition);
		} catch (NumberFormatException e) {
			jsonObject.put("error", "not a number");
		} catch (IllegalArgumentException e) {
			jsonObject.put("error", e.getMessage());
		}
		return jsonObject;
	}

}
