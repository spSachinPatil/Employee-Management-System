package com.handler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.bin.emp_bo;
import com.dao.login_dao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/delete_only_1")
public class delete_only_1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public delete_only_1() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();

		pw.print("<br><br><br><table border='1px' width='100%'> ");

		pw.print("<tr> <th> Id </th> <th> Name </th> <th> Email </th> <th> Phone "
				+ "</th> <th> Date Of Joining</th> <th> Date Of Birth</th>"
				+ " <th> Adhar Details</th><th> Delete</th></tr>");

		List<emp_bo> list = login_dao.fetch();

		for (emp_bo eb : list) {
			pw.print("<tr><td>" + eb.getId() + "</td><td>" + eb.getName() + "</td><td>" + eb.getEmail() + "</td><td>"
					+ eb.getPhone() + "</td><td>" + eb.getDoj() + "</td><td>" + eb.getDob() + "</td><td>"
					+ eb.getAdhar() + "</td><td><a href='Deleting?id=" + eb.getId() + "'>Delete </a></td></tr>");

		}

		pw.print("</table>");
		pw.print("<br><center><Button ><a href='home.html'>Back</a></Button><center>");
		pw.print("<link rel=\"stylesheet\" href=\"CSS/insert.css\">");

	}

}
