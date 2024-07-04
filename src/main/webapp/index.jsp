<%@page import="com.entity.student"%>
<%@page import="java.util.List"%>
<%@page import="com.dao.studentDao"%>
<%@page import="com.conn.DBConnection"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>student_managment_system</title>
<%@include file="allcss.jsp"%>
</head>
<body>
	<%@ include file="nav.jsp"%>

	<div class="container p-5">
		<div class="card">
			<div class="card-body">

				<p class="text-center fs-1">All student detail</p>
				<c:if test="${not empty succMsg}">
					<P class="text-center text-success">${succMsg}</P>
					<c:remove var="succMsg" />
				</c:if>

				<c:if test="${not empty errMsg}">
					<P class="text-center text-success">${errMsg}</P>
					<c:remove var="errMsg" />
				</c:if>
				<table class="table bg-light">
					<thead>
						<tr>
							<th scope="col">Full name</th>
							<th scope="col">DOB</th>
							<th scope="col">Address</th>
							<th scope="col">Qualification</th>
							<th scope="col">Email</th>
							<th scope="col">Action</th>
						</tr>
					</thead>
					<tbody>

						<%
						studentDao dao = new studentDao(DBConnection.getconn());
						List<student> list = dao.getallstudent();
						for (student s : list) {
						%>
						<tr>
							<th scope="row"><%=s.getFullname()%></th>
							<td><%=s.getDob()%></td>
							<td><%=s.getAddress()%></td>
							<td><%=s.getQualification()%></td>
							<td><%=s.getEmail()%></td>
							<td><a href="edit.jsp?id=<%=s.getId()%>"
								class="btn btn-sm btn-primary">Edit</a> <a
								href="delete?id=<%=s.getId()%>"
								class="btn btn-sm btn-danger ms-1">Delete</a></td>

						</tr>


						<%
						}
						%>


					</tbody>
				</table>
			</div>
		</div>
	</div>

</body>
</html>