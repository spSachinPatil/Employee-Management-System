package com.handler;

import java.io.IOException;
import java.io.PrintWriter;

import com.bin.emp_bo;
import com.dao.login_dao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/edit_servlet")
public class edit_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public edit_servlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();

		String id = request.getParameter("id");

		login_dao.getElementbyId(id);

		emp_bo eb = login_dao.getElementbyId(id);

		pw.print("<form action ='Update_controler' method='get'>");

		pw.print("<table>");

		pw.print("<tr>");

		pw.print("<tr><td></td><td><input type='hidden' name='id' value='" + eb.getId() + "'/></td></tr>");
		pw.print("<tr><td>Name: </td> <td><input type='text' name='name' value='" + eb.getName() + "'/></td></tr>");
		pw.print("<tr><td>Email: </td> <td><input type='text' name='email' value='" + eb.getEmail() + "'/></td></tr>");
		pw.print("<tr><td>Phone:</td> <td><input type='text' name='phone' value='" + eb.getPhone() + "'/></td></tr>");
		pw.print("<tr><td>Date of Joining : </td> <td><input type='text' name='doj' value='" + eb.getDoj()
		+ "'/></td></tr>");
		pw.print("<tr><td>Date of Birth: </td> <td><input type='text' name='dob' value='" + eb.getDob()
		+ "'/></td></tr>");
		pw.print("<tr><td>Adhar Card: </td> <td><input type='text' name='adhar' value='" + eb.getAdhar()
		+ "'/></td></tr>");

		pw.print("<tr><td><input type='submit' value='Update'/></td></tr>");

		pw.print("</table>");

		pw.print("</form>");

		pw.print("<Button><a href='for_serach'>Back</a></Button>");
		pw.print("<link rel=\"stylesheet\" href=\"CSS/insert.css\">");

	}

}