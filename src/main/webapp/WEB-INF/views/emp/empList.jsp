<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전체 사원 조회</title>
<style>
table, th, td {
	border: 1px solid black;
}
tr{
	cursor: pointer;
}
</style>
</head>
<body>
<div align="center">
	<button type="button" onclick="location.href='empInsert'">등록</button>
	<table>
		<thead>
			<tr>
				<th>NO.</th>
				<th>employee_id</th>
				<th>first_name</th>
				<th>last_name</th>
				<th>email</th>
				<th>hire_date</th>
				<th>job_id</th>
				<th>salary</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${empList}" var="e" varStatus="sts">
				<tr onclick="location.href='empInfo?employeeId=${e.employeeId}'">
					<td>${sts.count}</td>
					<td>${e.employeeId}</td>
					<td>${e.firstName}</td>
					<td>${e.lastName}</td>
					<td>${e.email}</td>
					<td>
						<fmt:formatDate value="${e.hireDate}" pattern="yyyy년MM월dd일" />
					</td>
					<td>${e.jobId}</td>
					<td>${e.salary}</td>

				</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
	<script>
	// jsp - servlet - java - html - css - javascript 컴파일순서
	let msg = `${result}`;
	
	if(msg != ''){
		alert(msg);
	}

	</script>

</body>
</html>