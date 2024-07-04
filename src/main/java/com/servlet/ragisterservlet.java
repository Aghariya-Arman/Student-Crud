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
import com.mysql.cj.Session;

@WebServlet("/register")
public class ragisterservlet extends HttpServlet {

		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			String name=req.getParameter("name");
			String dob=req.getParameter("dob");
			String address=req.getParameter("ad");
			String qualification=req.getParameter("qua");
			String email=req.getParameter("email");
			
			student St=new student(name,dob,address,qualification,email);
			
			HttpSession session=req.getSession();
			
			
			studentDao dao=new studentDao(DBConnection.getconn());
			boolean f=dao.addStudent(St);
			
			if (f) {
				session.setAttribute("succMsg", " Add succesfully");
				resp.sendRedirect("add_student.jsp");
				//System.out.println("add succesfull");
			}else {
				session.setAttribute("errMsg", " something went to wrong");
				resp.sendRedirect("add_student.jsp");
				//System.out.println("something wrong server");
			}
		}
}
