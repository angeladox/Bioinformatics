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
				<li><a href="/autocurate/">Homepage</a></li>
				<li><a href="/autocurate/about">About</a></li>
				<li><a href="/autocurate/ensemblInstructions">Links</a></li>
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
<h3><b>Curation Notes for Ensembl</b></h3>
Jeffrey Thompson

Thu Aug  9 08:53:19 EDT 2012
Updated Fri Nov 2 13:30:41 EDT 2012 describing how to find end of scaffold.
Updated Fri Jan 18 09:55:24 EST 2013 to add clearer instructions for 
handling cases when there is no upstream or downstream gene.

The point of this curation protocol is to search for a target gene in the
Ensembl database, find the gene upstream (or downstream) of it and use
the indices of both genes to download the DNA sequence between them.

With each curation we create two sets of files:
* A set of files named <speciesName>.either.txt
* A set of files named <speciesName>.same.txt

The 'either' files include the sequence between the target and the
next gene upstream of it no matter which strand it occurs on. The
'same' files include the sequence between the target gene and the next
gene upstream of it on the same strand it is on.

When determining which gene is the 'next', skip over pseudo-genes and
partial genes.

Save original files and notes from all curators, even after the files
have been compared.
---------------------------------------------------------------------

1) Goto lhttp://useast.ensembl.org/index.htm.

2) Type the abbreviation for the target gene into the search box near
   the top left of the page (e.g. CFTR) and hit Enter.

3) Click on any of the species under the 'By Species' list at the
   right of the page (e.g. Alpaca). Then click 'Gene'.

4) Now you should see a list of genes related to the search term. The
   first one is usually the target of the search. Click its heading
   (e.g. CFTR).

5) There is a menu with heading 'Gene-based displays' at the top left
   of the page. Under the 'Comparative Genomics' heading click
   'Orthologous.'

6) Under the heading 'Summary of orthologues of this gene' there is a
   list of species sets. Check the 'Show details' box for any species
   sets you are interested in (e.g. Fish).

7) Scroll to the bottom of the page to see a list of orthologous genes
   to the one you originally selected (e.g. fish species with
   CFTR). Now click the link under 'Ensembl identifier & gene name' to
   be taken to a display for that species.

8) Under 'Gene summary' near the bottom segment of the page there is
   now a graphical display of the gene. The target will be highlighted
   in green (even if its identifier is different than the one you
   searched for). Click the gene to see info about its location and strand.

9) Click the black and white bar at the top of the gene display and
   click 'Jump to location view.'

10) Under 'Region in detail' heading, click the gene to find its
    indices. Make a note of them.

11) Now click the gene upstream of your target and find its indices
    (if there is no upstream gene, look immediately beneath
    the gene display and note the ending index of the scaffold).

12) Click the target gene again and click the link by 'Gene.'

13) Click the 'Export data' button at the left of the page.

14) Now make sure the following options are selected: 
    * 'FASTA sequence' 
    * 'Feature strand'. 

    If you need to find scaffold indices for any of the instructions below,
    there are extra instructions at the end of this document.

    Next, if your gene is on the plus strand and you want the upstream
    region, go to step 14a.  If your gene is on the plus strand and
    you want the downstream region, go to step 14b.  If your gene is
    on the minus strand and you want the upstream region, go to step
    14c.  If your gene is on the minus strand and you want the
    downstream region, go to step 14d.

    In the 5' Flanking sequence (upstream) box enter the amount of
    upstream sequence to retrieve. Calculate it in the following way: if you

14a) (upstream/plus) In the 5' Flanking sequence (upstream) box, enter
     the value you get by taking the target gene's smaller index minus
     the upstream gene's larger index minus 1 (if no upstream gene, then use
     the target gene's smaller index minus 1). For example, if the target gene
     gene had a smaller index of 100 and the upstream gene had a larger index
     of 50, then you would enter 49, because 100 - 50 - 1 = 49.

     Under 'Options for FASTA sequence' make sure the 'Genomic' drop
     down box says '5' Flanking sequence'. The rest of the boxes
     should be unchecked.

     Finally, click 'Next'.

     Go to step 15.

14b) (downstream/plus) In the 3' Flanking sequence (downstream) box,
     enter the value you get by taking the downstream gene's smaller
     index minus the target gene's larger index minus 1 (if no 
     downstream gene, then use the end index of the scaffold minus
     the target gene's larger index).

     Under 'Options for FASTA sequence' make sure the 'Genomic' drop
     down box says '3' Flanking sequence'. The rest of the boxes
     should be unchecked.

     Finally, click 'Next'.

     Go to step 15.

14c) (upstream/minus) In the 5' Flanking sequence (upstream) box,
     enter the value you get by taking the upstream gene's smaller
     index minus the target gene's larger index minus 1 (if no 
     upstream gene, then use the scaffold's end index minus target 
     gene's larger index).

     Under 'Options for FASTA sequence' make sure the 'Genomic' drop
     down box says '5' Flanking sequence'. The rest of the boxes
     should be unchecked.

     Finally, click 'Next'.

     Go to step 15.

14d) (downstream/minus) In the 3' Flanking sequence (downstream) box,
     enter the value you get by taking the downstream gene's larger
     index minus the target gene's smaller index minus 1 (if no
     downstream gene, use the target gene's smaller index minus 1).

     Under 'Options for FASTA sequence' make sure the 'Genomic' drop
     down box says '3' Flanking sequence'. The rest of the boxes
     should be unchecked.

     Finally, click 'Next'.

     Go to step 15.

15) On the 'Export data' window that appears, click 'Text'. Copy and
    paste the resulting sequence to save it.

--------------------------------------------------------------------

Extra Instructions:

How to find the scaffold indices.

In the location view, if you need to know where the end of a scaffold is, look
at the location box (it is the second box down from the top of 'Region in
detail'. Remove the second index in the range and enter 9999999999, then click
'Go'. Ensembl will update the page and automatically change the second index
to the end of the scaffold.
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