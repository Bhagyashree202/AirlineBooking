package com.flight.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flight.model.Search;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {

	public void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		System.out.println("Inside servlet");
		Search.date = req.getParameter("date");
		Search.source = req.getParameter("source");
		Search.destination = req.getParameter("destination");
		Search.persons = Integer.parseInt(req.getParameter("persons"));

		if (Search.date.equals("")) {
			PrintWriter out = resp.getWriter();
			out.println("Please enter a valid date");
		} else {
			Search.day = getDay(Search.date);
			resp.sendRedirect(req.getContextPath()+"/search-results.jsp");
		}
	}

	public String getDay(String dateInp) {
		LocalDate dt = LocalDate.parse(dateInp);
		return dt.getDayOfWeek().toString();
	}

	/*
	 * protected void doGet(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException { // TODO Auto-generated
	 * method stub
	 * response.getWriter().append("Served at: ").append(request.getContextPath());
	 * request.getRequestDispatcher("/search-result.jsp") .forward(request,
	 * response); }
	 * 
	 *//**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
		 *      response)
		 *//*
			 * protected void doPost(HttpServletRequest request, HttpServletResponse
			 * response) throws ServletException, IOException { // TODO Auto-generated
			 * method stub doGet(request, response); }
			 */

}
