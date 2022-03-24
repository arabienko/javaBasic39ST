<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Upload Result</title>
<link  href="css\stylesheet" rel="stylesheet">
</head>
<body class = "content">
<div class = "content" >
<jsp:useBean id= "courseStudent" scope= "request" type = "java.util.Set"></jsp:useBean>
<br>
<a>User select parsing : ${parse}</a>
<br>
<table class="c">
 <tr class="cen">
    <th > ## </th>
   <th > Subject </th>
   <th > Teacher </th>
    <th > Student </th>
    <th > Start </th>
    <th > End </th>
    <th > Status </th>
     </tr>
     <c:forEach var="cs" items="${courseStudent}" varStatus="counter">
        <tr>
       <td> ${counter.count}</td>
      <td><c:out value= "${cs.teacherCourse.teacherSubject.subject.nameSubject}" /></td>
      <td><c:out value= "${cs.teacherCourse.teacherSubject.userInfo}" /></td>
      <td><c:out value= "${cs.userInfo}" /></td>
       <td><c:out value= "${cs.teacherCourse.startDate}" /></td>
      <td><c:out value= "${cs.teacherCourse.endDate}" /></td>
      <td><c:out value= "${cs.status}" /></td
      </tr>
     </c:forEach>
  </table>
 <input type="button" onclick="history.back();" value="return back"/>
 </div>
 </body>
</html>