<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Upload Result</title>
<link  href="css\stylesheet" rel="stylesheet">
</head>
<body>
<div class = "content" >
<jsp:useBean id= "courseStudent" scope= "request" type = "java.util.Set"></jsp:useBean>
<br>
<a>User select parsing : ${parse}</a>
<br>
<table class="c">
     <c:forEach var="cs" items="${courseStudent}">
     <tr>
     <th class="cen">Name table</th>
     <td class="cen">Table data</td>
     </tr>
   <tr>
   <th > Subject </th>
   <td><c:out value= "${cs.teacherCourse.teacherSubject.subject.nameSubject}" /></td>
   </tr>
      <tr>
      <th > Teacher </th>
      <td><c:out value= "${cs.teacherCourse.teacherSubject.userInfo}" /></td>
      </tr
      <tr>
      <th > Student </th>
      <td><c:out value= "${cs.userInfo}" /></td>
      </tr>
       <tr>
       <th > Start </th>
       <td><c:out value= "${cs.teacherCourse.startDate}" /></td>
       </tr>
      <tr>
      <th > End </th>
      <td><c:out value= "${cs.teacherCourse.endDate}" /></td>
      </tr>
      <tr>
      <th > Status </th>
      <td><c:out value= "${cs.status}" /></td>
      </tr>
     </c:forEach>
  </table>
 <input type="button" onclick="history.back();" value="return back"/>
 </div>
 </body>
</html>