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

<h4>Generate Non-Coding Sequences for a Target Gene</h4>
<a href="/CurationAutomation/generateFile/">Download the either file</a>

	<form method="post"
		action="/CurationAutomation/submit/">
		Target Gene :
		<input type="text" name="targetGene" size="24" maxlength="24" /> 
		<input type="submit" value="Search for Upstream Genes" />
	</form>

</body>
</html>