package com.handler;

import java.io.IOException;
import java.io.PrintWriter;



import com.bin.emp_bo;
import com.dao.login_dao;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Insert_emp")
public class Insert_emp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Insert_emp() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());

		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();

		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String doj = request.getParameter("doj");
		String dob = request.getParameter("dob");
		String adhar = request.getParameter("adhar");

		emp_bo eb = new emp_bo(id, name, email, phone, doj, dob, adhar);

		int status = login_dao.addEmployee(eb);

		if (status > 0) {
			System.out.println("Employee_add successfully");
			pw.print("Employee_add successfully");
			RequestDispatcher rd = request.getRequestDispatcher("home.html");
			rd.forward(request, response);
		} else {
			pw.print("Something wrong plese try again  <br>");
			RequestDispatcher rd = request.getRequestDispatcher("Insert.html");
			rd.include(request, response);
		}

	}

}