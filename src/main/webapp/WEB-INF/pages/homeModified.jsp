<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>autocurate</title>
<link
	href="http://fonts.googleapis.com/css?family=Arvo|Open+Sans:400,300,600,700"
	rel="stylesheet" type="text/css" />
<style>
body {
	margin: 0;
	padding: 0;
	background: #FFFFFF;
	font-family: 'Open Sans', sans-serif;
	font-size: 13px;
	color: #3B3B3B;
}

h1,h2,h3 {
	margin: 0px;
	padding: 0px;
	letter-spacing: -2px;
	text-transform: uppercase;
	font-family: 'Arvo', serif;
	font-weight: normal;
	color: #107710;
}

h1 {
	font-size: 2em;
}

h2 {
	font-size: 2.4em;
}

h3 {
	font-size: 1.6em;
}

p,ul,ol {
	margin-top: 0;
	line-height: 180%;
}

ul,ol {
	
}

a {
	text-decoration: none;
	color: #107710;
}

a:hover {
	
}

/* Header */
#header-wrapper {
	
}

#header {
	clear: both;
	width: 1200px;
	margin: 0px auto;
}

#oops {
	margin-left: 150px;
	padding: 30px 0px;
	color: #000000;
}
/* Logo */
#logo {
	margin: 0px;
	padding: 30px 0px;
	color: #000000;
}

#logo h1,#logo p {
	margin: 0;
	padding: 0;
}

#logo h1 {
	margin: 0px;
	padding: 0px;
	text-transform: lowercase;
	font-size: 3.8em;
	color: #323030;
}

#logo h1 span {
	color: #107710;
}

#logo p {
	margin: 0px;
	padding: 0px;
	text-transform: uppercase;
	font-family: 'Arvo', serif;
	color: #3B3B3B;
}

#logo p a {
	color: #3B3B3B;
}

#logo a {
	border: none;
	background: none;
	text-decoration: none;
	color: #323030;
}

/* Search */
#search {
	width: 320px;
	height: 60px;
	padding: 0px;
}

#search form {
	margin: 0px;
	padding: 0px;
}

#search fieldset {
	margin: 0;
	padding: 0;
	border: none;
}

#search-text {
	width: 210px;
	outline: none;
	background: #F5F0E7;
	border: 1px solid #D7D0C0;
	padding: 10px;
	border-radius: 8px;
	text-transform: lowercase;
	font-family: 'Open Sans', sans-serif;
	color: #454545;
}

#search-submit {
	width: 62px;
	height: 22px;
	display: none;
	border: none;
	color: #FFFFFF;
}

/* Menu */
#menu-wrapper {
	overflow: hidden;
	height: 56px;
	background: #000000;
	border-top: 1px solid #3D2729;
}

#menu {
	width: 1200px;
	height: 55px;
	margin: 0px auto;
	padding: 0px;
}

#menu ul {
	margin: 0;
	padding: 10px 0px 0px 0px;
	list-style: none;
	line-height: normal;
}

#menu li {
	float: left;
	border-right: 1px solid #543E40;
}

#menu a {
	display: block;
	letter-spacing: 1px;
	margin: 0px 10px;
	padding: 10px 20px;
	text-decoration: none;
	text-align: center;
	text-transform: uppercase;
	font-family: 'Arvo', serif;
	font-size: 14px;
	font-weight: normal;
	color: #FFFFFF;
	border: none;
}

#menu a:hover,#menu .current_page_item a {
	background: #107710;
	border-radius: 8px;
	text-decoration: none;
	color: #FFFFFF;
}

#menu .current_page_item a {
	background: #107710;
	border-radius: 8px;
}

/* Page */
#page {
	overflow: hidden;
	width: 1200px;
	margin: 0px auto;
	padding: 30px 0px;
}

/* Content */
#content {
	float: left;
	width: 700px;
	height: 300px;
}

.post {
	margin-bottom: 15px;
	padding: 30px 40px;
	border: 1px solid #E7DFD7;
	border-radius: 8px;
	background: #F8F8F8;
}

.post-bgtop {
	
}

.post-bgbtm {
	
}

.post .title {
	height: 38px;
	margin-bottom: 10px;
	padding: 12px 0 0 0px;
	font-size: 32px;
}

.post .title a {
	border: none;
	color: #107710;
}

.post .meta {
	margin-bottom: 30px;
	padding: 5px 0px 15px 0px;
	text-align: left;
	font-weight: normal;
}

.post .meta .date {
	float: left;
}

.post .meta .posted {
	float: right;
}

.post .meta a {
	
}

.post .entry {
	padding: 0px 0px 20px 0px;
	padding-bottom: 20px;
	text-align: justify;
}

.links {
	display: inline-block;
	height: 30px;
	padding: 30px 0px 0px 0px;
	font-size: 14px;
	font-weight: normal;
	color: #1C1C1C;
}

.button {
	padding: 10px 25px;
	background: #107710;
	border-radius: 5px;
	text-transform: uppercase;
	font-size: 12px;
	color: #FFFFFF;
}

/* Sidebar */
#sidebar2 {
	float: right;
	width: 250px;
	height: 800px;
	padding: 40px 30px 0px 30px;
	border: 1px solid #E7DFD7;
	border-radius: 8px;
	background: #F8F8F8;
}

#sidebar {
	float: left;
	width: 230px;
	margin-right: 30px;
	margin-bottom: 30px;
	height: 350px;
	padding: 40px 80px 0px 30px;
	color: #787878;
	border: 1px solid #E7DFD7;
	border-radius: 20px;
	background: #F8F8F8;
}

#sidebar ul,#sidebar2 ul {
	margin: 0;
	padding: 0px;
	list-style: none;
}

#sidebar li,#sidebar2 li {
	margin: 0;
	padding:0px;
}

#sidebar li ul,#sidebar2 li ul {
	margin: 0px 0px;
	padding-bottom: 50px;
}

#sidebar li li,#sidebar2 li li {
	border-bottom: 1px solid #E7DFD7;
	margin: 0px 0px;
	padding: 10px 0px;
	border-left: none;
}

#sidebar li li a,#sidebar2 li li a {
	color: #3B3B3B;
}

#sidebar li li span,#sidebar2 li li span {
	display: block;
	padding: 0;
	font-size: 11px;
	font-style: italic;
}

#sidebar h2,#sidebar2 h2 {
	padding-bottom: 20px;
	font-size: 1.8em;
	color: #107710;
}

#sidebar p,#sidebar2 p {
	margin: 0px 0px 40px 0px;
	padding: 0px;
	text-align: justify;
}

#sidebar a,#sidebar2 a {
	border: none;
}

#sidebar a:hover,#sidebar2 a:hover {
	text-decoration: underline;
}

/* Calendar */
#calendar {
	
}

#calendar_wrap {
	padding: 20px;
}

#calendar table {
	width: 100%;
}

#calendar tbody td {
	text-align: center;
}

#calendar #next {
	text-align: right;
}

/* Footer */
#footer {
	height: 50px;
	margin: 0 auto;
	padding: 0px 0 15px 0;
	background: #F8F8F8;
	border-top: 5px solid #E7DFD7;
	font-family: 'Arvo', serif;
}

#footer p {
	margin: 0;
	padding-top: 20px;
	line-height: normal;
	font-size: 12px;
	letter-spacing: 2px;
	text-transform: uppercase;
	text-align: center;
	color: #A0A0A0;
}

#footer a {
	color: #8A8A8A;
}

#banner {
	width: 1200px;
	margin: 40px auto 0px auto;
}

#banner img {
	border-radius: 8px;
}
</style>
</head>
<body>
	<div id="menu-wrapper">
		<div id="menu">
			<ul>
				<li class="current_page_item"><a href="#">Homepage</a></li>
				<li><a href="/autocurate/about">About</a></li>
				<li><a href="/autocurate/ensemblInstructions">"Old Process" Instructions</a></li>
			</ul>
		</div>
		<!-- end #menu -->
	</div>
	<!-- <div id="banner"><img src="img01.jpg" width="1200" height="300" alt="" /></div> -->
	<div id="header-wrapper">
		<div id="header">
			<div id="logo">
				<h1>
					<a href="/autocurate/about">Auto<span>Curate</span></a>
				</h1>
				<p>
					automated curation of genetic data to discover noncoding DNA sequences</a>
				</p>
			</div>
		</div>
	</div>
	<div id="oops">
				<h4>
					Oops! Something went wrong with your search. 
				</h4>
				<h4>This is an autocurate issue that we will do our best to resolve promptly.</h4>
				
			</div>
	<div id="wrapper">
		<!-- end #header -->
		<div id="page">
			<div id="page-bgtop">
				<div id="page-bgbtm">
					<div id="sidebar">
						<ul>
							<li>
								<h2>Search For a Target Gene Here:</h2>
								<h4>(Good candidates are: "cftr" or "capza2" for the human species)</h4>
								<div id="search">
									<form method="post" action="/autocurate/submit">							
										<div>
											<h4>Gene Name:</h4><input type="text" name="targetGene" /> 
											<br>
											<h4>Species Name:</h4><input type="text" name="speciesName" /> 
												<br><br>						
											<input type="submit" value="Search for Upstream Genes"  class="button"/>
											<br><br>
										</div>
									</form>									
									
								</div>
							</li>
							
						</ul>
					</div>
					<!-- end #sidebar -->
					<div id="content">
						<div class="post">
							<h2 class="title">
								<a href="#">Welcome to AutoCurate</a>
							</h2>
							<p class="meta">
								<span class="date">May 2013</span>
							</p>
							<div style="clear: both;">&nbsp;</div>
							<div class="entry">
								<p>
									This is <strong>autocurate</strong>, a free curation automation tool that allows researchers
									to discover noncoding regions of DNA with speed, accuracy, and consistency.
								</p>
								<p class="links">
									<a href="/autocurate/about" class="button">Read More</a>
								</p>
							</div>
						</div>
					</div>
					<!-- end #content -->
				</div>
			</div>
		</div>
		<!-- end #page -->
	</div>
	<div id="footer">
		<p>
			&copy; 2013 autocurate. |</a>
			| Bioinformatics: University of Southern
					Maine. Spring 2013.</a>
		</p>
	</div>
	<!-- end #footer -->
</body>
</html>