package org.jsp.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet{
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
		String sid = req.getParameter("i");
		int id=Integer.parseInt(sid);
		String name = req.getParameter("nm");
		String dept = req.getParameter("dp");
		String sperc = req.getParameter("pr");
		double perc=Double.parseDouble(sperc);
		
		
		PrintWriter out = resp.getWriter();
		out.print("<html><body bgcolor='green'> Student name is "+name +"from "+dept +"</body></html>");
		
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=MDmus@786");
			pstmt=con.prepareStatement("insert into firstproject.Student values(?,?,?,?)");
			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, dept);
			pstmt.setDouble(4, perc);
			
			pstmt.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
