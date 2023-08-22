package com.dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;
import com.bin.emp_bo;
import com.bin.login_do;

public class login_dao {

	public static Connection connect() {
		Connection con = null;

		String url = "jdbc:mysql://localhost:3306/sachin";
		String id = "root";
		String pass = "1234";

		try {
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection(url, id, pass);

		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}

	public static int insert(login_do lb) {
		int status = 0;

		try {

			Connection con = login_dao.connect();

			String qurey = "INSERT into login_1 values(?,?,?,?)";

			PreparedStatement ps = con.prepareStatement(qurey);

			ps.setString(1, lb.getName());
			ps.setString(2, lb.getEmail());
			ps.setString(3, lb.getPassword());
			ps.setString(4, lb.getRepassword());

			status = ps.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		}

		return status;
	}

	public static boolean user_logine(String Email, String pass) {
		boolean status = false;

		
		try {
			Connection con = login_dao.connect();

			String queary = "select *from login_1 where Email=? and pass=?";

			PreparedStatement ps = con.prepareStatement(queary);

			ps.setString(1, Email);
			ps.setString(2, pass);

			ResultSet rs = ps.executeQuery();

			status = rs.next();
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}

	public static int addEmployee(emp_bo eb) {

		int status = 0;

		try {

			Connection con = login_dao.connect();

			String queary = "insert into emp_22 values(?,?,?,?,?,?,?)";

			PreparedStatement ps = con.prepareStatement(queary);

			ps.setString(1, eb.getId());
			ps.setString(2, eb.getName());
			ps.setString(3, eb.getEmail());
			ps.setString(4, eb.getPhone());
			ps.setString(5, eb.getDoj());
			ps.setString(6, eb.getDob());
			ps.setString(7, eb.getAdhar());

			status = ps.executeUpdate();
		} catch (Exception e) {

			System.out.println(e);

		}

		return status;

	}

	public static List fetch() {
		List<emp_bo> list = new ArrayList<emp_bo>();

		try {

			Connection con = login_dao.connect();

			PreparedStatement ps = con.prepareStatement("select * from emp_22");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				emp_bo eb = new emp_bo();

				eb.setId(rs.getString(1));
				eb.setName(rs.getString(2));
				eb.setEmail(rs.getString(3));

				eb.setPhone(rs.getString(4));
				eb.setDoj(rs.getString(5));
				eb.setDob(rs.getString(6));

				eb.setAdhar(rs.getString(7));

				list.add(eb);

			}

		} catch (Exception e) {

			System.out.println(e);
		}

		return list;
	}

	public static int delete(String id) {

		int status = 0;

		try {

			Connection con = login_dao.connect();

			String query = "delete from emp_22 where id=?";

			PreparedStatement ps = con.prepareStatement(query);

			ps.setString(1, id);

			status = ps.executeUpdate();

		} catch (Exception e) {

			System.out.println(e);
		}

		return status;

	}

	public static int update(emp_bo eb) {
		int status = 0;

		try {

			Connection con = login_dao.connect();

			String query = "update emp_22 set name=?,email=?,phone=?, doj=?,dob=?,Adhar=? where id=?";

			PreparedStatement ps = con.prepareStatement(query);

			ps.setString(1, eb.getName());
			ps.setString(2, eb.getEmail());
			ps.setString(3, eb.getPhone());
			ps.setString(4, eb.getDoj());
			ps.setString(5, eb.getDob());
			ps.setString(6, eb.getAdhar());
			ps.setString(7, eb.getId());

			status = ps.executeUpdate();

		} catch (Exception e) {

			System.out.println(e);
		}

		return status;

	}

	public static emp_bo getElementbyId(String id) {

		emp_bo eb = new emp_bo();

		try {
			Connection con = login_dao.connect();

			String query = "select *from emp_22 where id=?";

			PreparedStatement ps = con.prepareStatement(query);

			ps.setString(1, id);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				eb.setId(rs.getString(1));
				eb.setName(rs.getString(2));
				eb.setEmail(rs.getString(3));

				eb.setPhone(rs.getString(4));
				eb.setDoj(rs.getString(5));
				eb.setDob(rs.getString(6));

				eb.setAdhar(rs.getString(7));
			}

		} catch (Exception e) {

			System.out.println(e);
		}

		return eb;
	}

	public static List search(String id) {
		int status = 0;

		List<emp_bo> ob = new ArrayList();

		try {
			Connection con = login_dao.connect();

			String s = "select *from emp_22 where id=?";

			PreparedStatement ps = con.prepareStatement(s);

			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				emp_bo lbo = new emp_bo();
				lbo.setId(rs.getString(1));
				lbo.setName(rs.getString(2));
				lbo.setEmail((rs.getString(3)));
				lbo.setPhone((rs.getString(4)));
				lbo.setDoj(rs.getString(5));
				lbo.setDob((rs.getString(6)));
				lbo.setAdhar((rs.getString(7)));

				ob.add(lbo);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		return ob;
	}
}
