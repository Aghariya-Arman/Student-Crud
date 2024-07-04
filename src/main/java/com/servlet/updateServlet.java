package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.conn.DBConnection;
import com.dao.studentDao;
import com.entity.student;

@WebServlet("/update")
public class updateServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name=req.getParameter("name");
		String dob=req.getParameter("dob");
		String address=req.getParameter("ad");
		String qualification=req.getParameter("qua");
		String email=req.getParameter("email");
		int id=Integer.parseInt(req.getParameter("id"));
		
		student St=new student(id,name,dob,address,qualification,email);
		
		studentDao dao=new studentDao(DBConnection.getconn());
		
		HttpSession session=req.getSession();
		
		boolean f=dao.updatesudent(St);
		
		if (f) {
			session.setAttribute("succMsg", " update succesfully");
			resp.sendRedirect("index.jsp");
			//System.out.println("add succesfull");
		}else {
			session.setAttribute("errMsg", " something went to wrong");
			resp.sendRedirect("index.jsp");
			//System.out.println("something wrong server");
		}
	}
}
