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

@WebServlet("/Update_controler")
public class Update_controler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Update_controler() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();

		String id = request.getParameter("id");

		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String doj = request.getParameter("doj");
		String dob = request.getParameter("dob");
		String adhar = request.getParameter("adhar");

		emp_bo eb = new emp_bo();

		eb.setId(id);
		eb.setName(name);
		eb.setEmail(email);
		eb.setPhone(phone);
		eb.setDoj(doj);
		eb.setDob(dob);
		eb.setAdhar(adhar);

		int status = login_dao.update(eb);

		if (status > 0) {
			RequestDispatcher rd = request.getRequestDispatcher("fetchiing");

			rd.forward(request, response);
		}

		pw.print("<Button><a href='for_serach'>Back</a></Button>");
		pw.print("<link rel=\"stylesheet\" href=\"CSS/insert.css\">");

	}

}