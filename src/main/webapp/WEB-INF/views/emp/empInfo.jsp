<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

		<!DOCTYPE html>
		<html>

		<head>
			<meta charset="UTF-8">
			<title>사원정보 조회</title>
			<script src="https://code.jquery.com/jquery-3.7.1.js"
				integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
		</head>

		<body>
			<form>
				<div>
					<label>employee_id: <input type="text" name="employeeId" value="${empInfo.employeeId }"
							readonly="readonly"></label>
				</div>
				<div>
					<label>last_name: <input type="text" name="lastName" value="${empInfo.lastName }" readonly></label>
				</div>
				<div>
					<label>email: <input type="text" name="email" value="${empInfo.email }"></label>
				</div>
				<div>
					<label>hire_date: <input type="date" name="hireDate"
							value='<fmt:formatDate value="${empInfo.hireDate }" pattern="yyyy-MM-dd" />' readonly></label>
				</div>
				<div>
					<label>job_id: <input type="text" name="jobId" value="${empInfo.jobId }" readonly></label>
				</div>
				<div>
					<label>salary: <input type="number" name="salary" value="${empInfo.salary }"></label>
				</div>
				<div>
					<button type="button" id="updateBtn">수정</button>
					<button type="button" onclick="location.href='empDelete?employeeId=${empInfo.employeeId}'">삭제</button>
					<button type="button" onclick="location.href='empList'">목록으로</button>
				</div>
			</form>
			<script>
				//자바스크립트버전
				document.querySelector('#updateBtn')
					.addEventListener('click', updateEmpInfo);

				function updateEmpInfo(event) {
					//form 태그 내부의 input을 기반으로 수정할 대상 정보를 가져옴
					let empInfo = getEmpInfo();
					//해당 정보를 기반으로 Ajax - QueryString
					fetch('empUpdate', {
						method: 'post',
						body: new URLSearchParams(empInfo)
					})
						.then(response => response.json())
						.then(result => {
							console.log('QueryString', result);
						})
						.catch(err => console.log(err));
					//해당 정보를 기반으로 Ajax - Json 
					fetch('empUpdateAjax', {
						method: 'post',
						headers: {
							'content-type': 'application/json'
						},
						body: JSON.stringify(empInfo)
					})
						.then(response => response.json())
						.then(result => {
							console.log('Json', result);
						})
						.catch(err => console.log(err));
				}

				function getEmpInfo() {
					let inputList = document.querySelectorAll('form input');

					let objData = {};

					inputList.forEach(tag => {
						objData[tag.name] = tag.value;
					});

					return objData;
				}

			</script>
			<script>
				//jQuery 버전
				$('#updateBtn').on('click', updateEmpInfoAjax);

				function updateEmpInfoAjax(event) {

					let empInfo = getEmpInfoAjax();

					//Ajax -> Query String
					$.ajax('empUpdate', {
						type: 'post',
						data: empInfo

					})
						.done(result => {
							console.log("QueryString", result);
						})
						.fail(err => console.log(err));

					//Ajax -> Json
					$.ajax('empUpdateAjax', {
						type: 'post',
						contentType: 'application/json',
						data: JSON.stringify(empInfo)
					})
						.done(result => {
							console.log("Json", result);
						})
						.fail(err => confirm.log(err));

					return false;
				}

				function getEmpInfoAjax() {
					let formDta = $('form').serializeArray();
					console.log(formDta);
					//[ {name: 'emeployeeId', value : '1052'} <= 형태 반복]

					let objDta = {};
					$.each(formDta, (idx, obj) => {	//each는 매개변수가 반드시 두개가 필요
						objDta[obj.name] = obj.value;
					});
					return objDta;
				}
			</script>

		</body>

		</html>