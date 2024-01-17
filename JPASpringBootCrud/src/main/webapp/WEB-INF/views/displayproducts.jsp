<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<style type="text/css">
    <%@include file="displayproducts.css" %>
</style>
<style>
.butt {
  background-color: #04AA6D; /* Green */
  border: none;
  color: #5BB9B8;
  padding: 16px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  transition-duration: 0.4s;
  cursor: pointer;
}
.button3 {
  background-color: #5BB9B8;; 
  color: black; 
  border: 2px solid #f44336;
}

.button3:hover {
  background-color: #f44336;
  color: white;
}
</style>
</head>
<body>
<main>
  <table>
    <thead>
      <tr>
        <th>Productid</th>
        <th>Title</th>
        <th>Description</th>
        <th>Unitprice</th>
        <th>Categoryid</th>
        <th>Unitinstock</th>
        <th>Action</th>
      </tr>
    </thead>
    <tbody>
      
      <c:forEach var="p" items="${plist}">
      	<tr>
      	<td data-title='Provider Name'>${p.pid}</td>
		<td data-title='Provider Name'>${p.title}</td>
		<td data-title='Provider Name'>${p.des}</td>
		<td data-title='Provider Name'>${p.unit}</td>
		<td data-title='Provider Name'>${p.catid}</td>
		<td data-title='Provider Name'>${p.unitstock}</td>
		<td class='select'>
		<a href="editprod/${p.pid}" class='button'>edit</a><br>
		<a href="deleteprod/${p.pid}" class="btn btn-danger">delete</a>
		</td>
		</tr>
	  </c:forEach>
      
    </tbody>
  </table>
</main>
<br>
<div style="text-align: center;">
<h2><a href="addprod" type="button" class="btn btn-outline-primary" style="font-size: 25px; ">Add New Product</a></h2>
<h2><a href="SpringMVCCrud/" type="button" class="butt button3" style="font-size: 25px; ">Logout</a></h2>
</div>
</body>
</html>