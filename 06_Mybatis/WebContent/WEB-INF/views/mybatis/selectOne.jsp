<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>학생정보</title>
<style>
	div#student-container{text-align: center;}
	table.tbl-student{
		margin: 0 auto;
		border: 1px solid;
		border-collapse: collapse;
	}
	th,td{
		border: 1px solid;
		padding: 5px;
	}
	th{text-align: right;}
	td{text-align: left;}
	tr:last-of-type td{text-align: center;}
</style>
<script src="${pageContext.request.contextPath }/js/jquery-3.3.1.js"></script>
</head>
<body>
	<div id="student-container">
		<h2>학생정보검색</h2>
		<p>총 학생수는 ${count }명 입니다.</p>
		
		<form action="${pageContext.request.contextPath }/student/selectOne.do">
			<table class="tbl-student">
				<tr>
					<th>학생번호</th>
					<td>
						<input type="number" name="no" value="${param.no }" />
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="검색" />
					</td>
				</tr>
			</table>
		</form>
		<c:if test="${not empty studentName }">
			<p>학생이름은 ${studentName }입니다.</p>
		</c:if>
		<c:if test="${not empty param.no && empty studentName }">
			<p>해당 학생은 존재하지 않습니다.</p>
		</c:if>
		
		<hr />
		<h2>@실습문제 특정 학생 삭제하기</h2>
		<p>삭제처리후에는 사용자에게 피드백을 준 후 현재페이지로 리다이렉트 시킬것.</p>
		<form action="${pageContext.request.contextPath }/student/deleteStudent.do">
			<table class="tbl-student">
				<tr>
					<th>삭제할 학생번호</th>
					<td>
						<input type="number" name="no" />
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="삭제" />
					</td>
				</tr>
			</table>
		</form>
		<c:if test="${not empty deleteResult}">
			<p>${deleteResult}명의 학생이 정상적으로 삭제 되었습니다.</p>
		</c:if>
		<c:if test="${deleteResult ==0 }">
			<p>삭제되지 않았습니다.</p>
		</c:if>
		
		
		<hr />
		<h2>@실습문제 : ajax로 학생 한명 정보 가져오기</h2>
		<table class="tbl-student">
			<tr>
				<th>조회할 학생번호</th>
				<td>
					<input type="number" name="no" id="selectAjax" />
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="button" id="btn-ajax-search" value="조회" />
				</td>
			</tr>
		</table>
		<div>
			<table id="tbl-ajax-student" class="tbl-student">
			
			</table>
		</div>
	</div>
	<script>
		$(function(){
			$("#btn-ajax-search").click(function(){
				var selectAjax = $("#selectAjax").val();
				$.ajax({
					url: "${pageContext.request.contextPath}/student/studentSelectAjax.do",
					dataType: "json",
					data: {studentNo: selectAjax},
					success: function(data){
						var html = "";
						console.log(data);
						html += "<tr><td>"+data+" 학생이 조회되었습니다.</td></tr>";
						
						$("#tbl-ajax-student").html(html);
					},
					error: function(){
						console.log("ajax처리 실패");
					}
				});
				
			});
		});
	</script>
		
</body>
</html>