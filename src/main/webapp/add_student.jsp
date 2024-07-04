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
<body class="bg-light">
	<%@ include file="nav.jsp"%>

	<div class="container p-4">
		<div class="row">
			<div class="col-md-6 offset-md-3">

				<div class="card">
					<div class="card-body">
						<p class="fs-3 text-center">Add Student</p>
						<c:if test="${not empty succMsg}">
							<P class="text-center text-success">${succMsg}</P>
							<c:remove var="succMsg" />
						</c:if>

						<c:if test="${not empty errMsg}">
							<P class="text-center text-success">${errMsg}</P>
							<c:remove var="errMsg" />
						</c:if>

						<form action="register" method="post">
							<div class="mb-3">
								<label class="form-label"> Full Name</label> <input type="text"
									class="form-control" name="name">
							</div>
							<div class="mb-3">
								<label class="form-label"> Date of Birth</label> <input
									type="date" class="form-control" name="dob">
							</div>
							<div class="mb-3">
								<label class="form-label"> Address</label> <input type="text"
									class="form-control" name="ad">
							</div>
							<div class="mb-3">
								<label class="form-label"> Qualification</label> <input
									type="text" class="form-control" name="qua">
							</div>
							<div class="mb-3">
								<label class="form-label">Email</label> <input type="email"
									class="form-control" name="email">
							</div>

							<button type="submit" class="btn btn-primary col-md-12">Submit</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>