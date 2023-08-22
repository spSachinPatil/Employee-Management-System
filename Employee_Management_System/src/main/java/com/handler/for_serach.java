package com.handler;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/for_serach")
public class for_serach extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public for_serach() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("Text/Html");

		PrintWriter pw = response.getWriter();

		pw.print("<center><br><br><br><center><form action=\"serching_only_1\" method=\"Get\">"
				+ "<tr><td><label for=\"\"><h3 id=\"aa\"> " + "Enter the ID of Employee :</h3></lable></td>"
				+ "<td><input type=\"text\"Name=\"id\"id=" + "\"bb\" placeholder=\"Enter Id Searching...\"><br>"
				+ "<td><button type=\"submit\"id=\"but\">" + "Serach...</button></td></tr>" + " &nbsp&nbsp&nbsp");

		pw.print("<Button><a href='home.html'>Back</a></Button>");
		pw.print("<link rel=\"stylesheet\" href=\"CSS/insert.css\"></center>");

		pw.close();

	}

}
