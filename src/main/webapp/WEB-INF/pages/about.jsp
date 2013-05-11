<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Auto-Curate</title>
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
	width: 1000px;
	height: 2000px;
	margin-left: 125px;
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
	<div id="content">
						<div class="post">
							<h2 class="title">
								<a href="#">About AutoCurate</a>
							</h2>
							
							
							<div id="logo">
								<p>Last updated 10 May 2013</p>
								<p>Angela Doxsey (angela.doxsey@yahoo.com)</p>
							</div>
							<div style="clear: both;">&nbsp;</div>
							<div class="entry">
							
<h3><b>Background</b></h3>
<br>

<p>Biological researchers perform curations of genetic data to find noncoding regions of DNA. Noncoding regions of DNA are 
important because they often contain short stretches involved in gene regulation. Proteins bind to specific sites,  
called transcription factor binding sites, within these noncoding regions. The binding proteins (the "transcription factors") 
cause genes to be turned on and off or express faster or slower.

<p>Transcription factors are important components of signaling cascades
that control all types of normal cellular processes (TRANSFAC Transcription Factor Binding Sites).
 They also control our bodies' response to external stimulus and conditions of disease drug treatment. Transcription factor
  binding sites specifically are significant because analysis of them allows us to better understand the mechanism of protein
   regulation and the coordination of regulation by multiple transcription factors acting together (TRANSFAC Transcription 
   Factor Binding Sites). In this way, we are able to effectively identify and characterize mutations that disrupt the regulatory
    mechanism and predict (currently) uncharacterized binding sites to understand normal and disease processes. 
</p>

<p>The data required to perform curations to download noncoding DNA sequences is available online in multiple databases, 
including the Ensembl database. Currently, there are tedious curation protocols to search for a target gene on a chromosome, 
find genes upstream of the target gene, and use the indices of these genes to download the noncoding DNA sequence between the
 target and upstream or downstream gene. Autocurate allows researchers to perform this curation process in a single step 
 rather than via an error-prone sequence of tasks. It considerably increases the speed with which noncoding regions of DNA  
 are discovered.</p>
<br><br>
<h3><b>Implementation</b></h3>

<p>Autocurate uses an Application Programming Interface (API) called JEnsembl to communicate with the Ensembl cloud server, 
which produces genome databases for vertebrates and other eukaryotic species.</p>

<p>Ensembl provides researchers with the functionality to automatically annotate genomic data and integrate it with other 
biological data (Ensembl Genome Browser). This annotation process identifies the locations of genes and all of the coding 
regions in a genome and determining what those genes do.  The DNA sequences and assemblies used in the Ensembl genebuild 
are provided by various projects around the world.</p>

<p>JEnsembl provides software developers  with a means to access data and functions already embedded within Ensembl 
(JEnsembl API project). Its functionality encompasses that which is necessary to perform genetic curations. This 
includes coordinate mapping of genes on a chromosome and the retrieval of relevant genetic information, such as DNA strand resolution.</p>

<p>My application specifically uses JEnsembl to perform calculations on genetic indices on a given chromosome within
 the Ensembl database to find noncoding regions of DNA. The code burden necessary to make this possible was lightened 
 because JEnsembl is capable of performing web queries to collect genomic data from Ensembl, manipulate that data in 
 manifold ways, and present it in the context of objects written in the Java programming language.</p>

<p>
Because the software was required to export a noncoding DNA sequence relevant to the target gene specified in the 
initial query, the most critical issue in the development of the autocurate software was to insure that the appropriate
 upstream gene was located for each target gene query. The process of retrieving of this gene is revealed in the following method:</p>

<p>First, the application queries the Ensembl database for the target gene belonging to the relevant species inputted 
by the user. All pertinent information about the target gene, including the chromosome it belongs to, the DNA strand
 (forward or reverse) it resides on, its beginning and ending indices, are saved. Next, the application queries Ensembl
  for all of the genes on the same chromosome of the target gene. The application then performs a filter on the retrieved
   genes, only saving those that have indices greater than the target, as these are the upstream genes. The resulting
    subset of genes are then categorized as forward strand or reverse strand genes based on whether they reside on the 
    forward or reverse DNA strand of that chromosome. </p>

<p>Next, a calculation is made based on whether the target gene inputted is on the forward or reverse DNA strand. 
If the target is on the forward strand, each upstream gene's larger index is subtracted from the target gene's 
smaller index. The value that results in this calculation is compared to the lowest value that the same calculation
 for all other upstream genes has resulted in so far (the initial value is an impossibly large number). The upstream 
 gene that results in the  lowest value achieved by this calculation is marked as the appropriate upstream gene.</p>

<p>Once the upstream gene has been located, the application only needs to retrieve the noncoding DNA sequence between 
the target and upstream gene. To do so, the application queries the Ensembl database for the sequence that resides 
between the larger index of the target gene and the smaller index of the upstream gene that resulted from the above process.</p>

<p>To generate the sequence desired by the user, the application displays a header that includes the Stable ID of the 
target gene, the Stable ID of the upstream gene, and the type of the upstream gene (i.e. known protein coding). It 
also displays the noncoding DNA sequence retrieved by the above process.</p>
<br><br>
<h3><b>Results and Discussion</b></h3>

<p>Autocurate significantly reduces the burden of discovering noncoding DNA sequences for a particular target gene 
and species. It takes an average of one minute to retrieve the appropriate noncoding sequence.
Before autocurate, researchers had to perform manual curations. This meant they were required to access the Ensembl 
Genome Browser,  type the abbreviation for the target gene, click on the desired species, find the target from the 
resulting list of search results, and search again for that gene's orthologs. Once the orthologs were found, they 
would have to navigate multiple graphical displays of the gene to find the correct upstream genes, double checking 
to be sure that these were not pseudogenes or other undesired types of genes. At this point, the indices for the target 
gene and upstream gene could be noted. Depending on the strand of the upstream gene, the curator would perform a calculation 
on the given indices. Finally, the sequence resulting from these calculations would be downloaded and pasted into a text file. 
With autocurate, researchers only have to type in the name of their target gene and the desired species. Researchers do 
not have to worry about navigating graphical displays or performing calculations with indices. The 
desired sequence is automatically displayed on the screen for copy and paste into a text file.</p>

<p>That being said, autocurate currently has several weaknesses. These weaknesses are due to time constraints on the project,
along with vulnerabilities and unpredictabilities within the JEnsembl API. Autocurate does not have a 100% success rate for finding
the proper protein-coding upstream gene and relevant noncoding DNA sequence, or
even a current measure of its ratio to success or failure. A few key known instabilities in the JEnsembl API provide explanation for 
this lack of a consistency.</p>

<p>JEnsembl's API contains objects that inherit from parent objects but on occasion neglects to set their fields. This means that an 
object may appear to have a method to retrieve a parent attribute, such as a display ID, but in reality this attribute does not exist. 
A simple call to a getID() method therefore results in an exception in the autocurate implementation code. This meant that replacements 
for these methods were required for the autocurate program, virtually proving portions of the JEnsembl API to be moot.</p> 

<p>The above deficiency may have been mitigated by copious, strong documentation; yet, JEnsembl is weak in this area as well. 
Often examples in documentation would result in errors in code. A good example is that what would appear to be a legal cast 
on an object in a tutorial would result in a class-cast exception when the tutorial code was used in production. 
These types of imperfections in an API's documentation can result in difficulties in writing error-free implementation code, 
as the implementations assume that the functions they are performing in the way we expect when in actuality they are not. 
For autocurate, this often meant that even the simplest JEnsembl API functions, such as a to-string function, could be misleading
in the values they were returning.</p>

<p>The above explanation is not meant to deter future implementors from utilizing the JEnsembl API. It is rather to provide
caution in using the services and perceived convenience the API offers. All-in-all, JEnsembl improved the development process of autocurate
immensely and proved to be a solid starting point for accessing Ensembl resources in the Java programming language. Autocurate is a work
in progress that will continue to use the JEnsembl API to tie up loose ends and eventually guarantee a high success rate for the 
discovery of noncoding DNA sequences.</p>

<p>The current result produced by a single query in autocurate will result in a header with the Stable ID of the upstream gene,
followed by the Stable ID of the target gene, followed by the type of sequence, i.e. cdna: known protein coding. The noncoding sequence
 is displayed on the screen with 60 nucleotides per line. This is modeled by FASTA format outputted by Ensembl.</p>

<br><br>
<h3><b>Future Work</b></h3>
<p>Autocurate can and should be extended to include many other features. As is mentioned above, autocurate
requires improvement in order to provide its users with 100% correct results. In addition, autocurate currently only generates 
what is referred to by researchers as an "either" sequence (see "Old Process Instructions" section). This sequence is the gene sequence
 between the target and the next gene upstream of it no matter which strand it occurs on. Autocurate should be expanded to also generate 
 a "same" sequence, which indicates the sequence between the target gene and the next gene upstream of it on the same strand it is on.
 Autocurate should be capable of locating these sequences and automatically producing the relevant text files for download.
  It should also be expanded to locate downstream genes to improve the quality of research that users require in their motivation for
   using autocurate. </p>


<p>When searching for candidate upstream genes, autocurate currently skips over overlapping and non-protein-coding genes. 
Ideally, autocurate would allow its users to specify whether or not they would like to include overlapping and other types 
of genes, such as antisense genes. In addition, curation is also done with DNA introns. Autocurate should include the 
capability to curate introns.</p>

<p>Finally, curation is not only done with the Ensembl database. In the USM lab alone, the NCBI database is used to perform
 curations. Expanding autocurate to perform queries on a user-specified database would make the application flexible and comprehensive.</p>

<br><br>
<h3><b>Availability and requirements</b></h3>
<ul>
<li><b>Project name:</b> autocurate: Automated Curation of Genetic Data to Discover Noncoding DNA Sequences</li>
<li><b>Project home page:</b> <a href="/autocurate/">http://gerald.rcg.usm.maine.edu:8080/autocurate/</a></li>
<li><b>Source code available from: </b><a href="https://github.com/angeladox/Bioinformatics">https://github.com/angeladox/Bioinformatics</a></li>
<li><b>Programming language:</b> Java</li>
<li><b>Requirements for self-deployment:</b> Java JDK 1.7 or higher, Tomcat 7.0 or higher</li></ul>
<br><br>
<h3><b>Acknowledgements</b></h3>

<p>I would like to thank co-Bioinformatics students Jeffrey Thompson and Theresa Hoyt for their continuous help from their 
curation expertise. I'd like to thank Clare Congdon for introducing me to the world of Bioinformatics and her plentiful 
assistance and encouragement on this project. </p>
<br><br>
<h3><b>References</b></h3>

<ul>
<li>The Ensembl Genome Browser. <a href="http://uswest.ensembl.org/index.html">http://uswest.ensembl.org/index.html.</a></li>

<li>The JEnsembl API project. <a href="http://jensembl.sourceforge.net/">http://jensembl.sourceforge.net/.</a></li>

<li>Thompson, J. Ensembl Curation Instructions. 9 August 2012.</li>

<li>TRANSFAC Transcription Factor Binding Sites <a href="http://www.biobase-
international.com/product/transcription-factor-binding-sites">http://www.biobase-
international.com/product/transcription-factor-binding-sites</a></li></ul>
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