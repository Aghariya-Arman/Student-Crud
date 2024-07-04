
<%@page import="com.entity.student"%>
<%@page import="com.conn.DBConnection"%>
<%@page import="com.dao.studentDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>student_managment_system</title>
<%@include file="allcss.jsp"%>
</head>
<body class="bg-light">
	<%@ include file="nav.jsp"%>

	<div class="container p-4">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<div class="card">
					<div class="card-body">
						<p class="fs-3 text-center">Edit Student</p>




						<%
						int id = Integer.parseInt(request.getParameter("id"));
						studentDao dao = new studentDao(DBConnection.getconn());
						student s = dao.getstudentbyid(id);
						%>

						<form action="update" method="post">
							<div class="mb-3">
								<label class="form-label"> Full Name</label> <input type="text"
									class="form-control" name="name" value="<%=s.getFullname()%>">
							</div>
							<div class="mb-3">
								<label class="form-label"> Date of Birth</label> <input
									type="date" class="form-control" name="dob"
									value="<%=s.getDob()%>">
							</div>
							<div class="mb-3">
								<label class="form-label"> Address</label> <input type="text"
									class="form-control" name="ad" value="<%=s.getAddress()%>">
							</div>
							<div class="mb-3">
								<label class="form-label"> Qualification</label> <input
									type="text" class="form-control" name="qua"
									value="<%=s.getQualification()%>">
							</div>
							<div class="mb-3">
								<label class="form-label">Email</label> <input type="email"
									class="form-control" name="email" value="<%=s.getEmail()%>">
							</div>

							<input type="hidden" value="<%=s.getId()%>" name="id">
							<button type="submit" class="btn btn-primary col-md-12">Update</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>