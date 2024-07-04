package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.student;



public class studentDao {
	
	private Connection conn;

	public studentDao(Connection conn) {
		super();
		this.conn = conn;
	}
	
	//add student code
		public boolean addStudent(student St) {
			
			boolean f=false;
			
			try {
				
				String sql="insert into student_db(name,dob,address,qualification,email) values (?,?,?,?,?)";
				PreparedStatement ps=conn.prepareStatement(sql);
				
				ps.setString(1, St.getFullname());
				ps.setString(2, St.getDob());
				ps.setString(3, St.getAddress());
				ps.setString(4, St.getQualification());
				ps.setString(5, St.getEmail());
				
				int i=ps.executeUpdate();
				
				if (i==1) {
					f=true;
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return f;
		}
		
		//show student detail code
		public List<student> getallstudent(){
			
			List<student> list=new ArrayList<student>();
			student s=null;
			try {
				String sql=" select * from student_db";
				PreparedStatement ps=conn.prepareStatement(sql);
				
				ResultSet rs=ps.executeQuery();
				 
				while(rs.next()) {
					s=new student();
					s.setId(rs.getInt(1));
					s.setFullname(rs.getString(2));
					s.setDob(rs.getString(3));
					s.setAddress(rs.getString(4));
					s.setQualification(rs.getString(5));
					s.setEmail(rs.getString(6));
					list.add(s);
					
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;
		}
		
		//edit student code
		public student getstudentbyid(int id) {
			
			student s=null;
			
			try {
				
				String sql="select * from student_db where id=?";
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setInt(1, id);
				
				ResultSet rs=ps.executeQuery();
				while(rs.next()) {
					s=new student();
					
					s.setId(rs.getInt(1));
					s.setFullname(rs.getString(2));
					s.setDob(rs.getString(3));
					s.setAddress(rs.getString(4));
					s.setQualification(rs.getString(5));
					s.setEmail(rs.getString(6));
					
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return s;
		}
		
		//update student code
		
		public boolean updatesudent(student St) {
			boolean f=false;
			
			try {
				
				String sql="update student_db set name=?,dob=?,address=?,qualification=?,email=? where id=?";
				PreparedStatement ps=conn.prepareStatement(sql);
				
				ps.setString(1, St.getFullname());
				ps.setString(2, St.getDob());
				ps.setString(3, St.getAddress());
				ps.setString(4, St.getQualification());
				ps.setString(5, St.getEmail());
				ps.setInt(6, St.getId());
				
				int i=ps.executeUpdate();
				
				if (i==1) {
					f=true;
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return f;
		}
		
		public boolean deleteStudent(int id) {
			boolean f=false;
			try {
				String sql="delete from student_db where id=?";
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setInt(1, id);
				
				int i=ps.executeUpdate();
				
				if (i==1) {
					f=true;
				}
				

			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
			return f;
		}
}
