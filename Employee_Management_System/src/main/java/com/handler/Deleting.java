package com.handler;

import java.io.IOException;
import java.io.PrintWriter;

import com.dao.login_dao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Deleting")
public class Deleting extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Deleting() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());

		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();

		String id = request.getParameter("id");

		login_dao.delete(id);

		response.sendRedirect("delete_only_1");
	}
}