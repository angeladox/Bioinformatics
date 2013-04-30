<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Auto-Curate</title>
<style>
* {
	font-size: 15px;
	font-family: tahoma;
}
</style>
</head>
<body>

<h4>Submit</h4>
<%-- <p><b>The plus gene is </b></p>
<p>${thePlusGene}</p>
<br>
<p><b>The minus gene is </b>${theMinusGene}</p> --%>
<br>
<p><!-- <b>The same sequence is: </b>  -->${sameSequence}</p>
<br>
<p><!-- <b>The either sequence is: </b> ${eitherSequence}</p>--> 

<a href="/CurationAutomation/generateEitherFile/">Click here to generate the either file</a>




</body>
</html>