<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<title><tiles:getAsString name="title" /></title>
<meta charset="utf-8">


<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	>
	<link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" ></script>


<style type="text/css">
.blockquote {
	padding: 20px;
	box-shadow: inset 0 -3em 3em rgba(0, 0, 0, 0.1), 0 0 0 2px
		rgb(255, 255, 255), 0.3em 0.3em 1em rgba(0, 0, 0, 0.3);
}

.imageHeight {
	height: 380px;
}

.linkSize {
	font-size: 14px;
}
.bgcolor{
	background-color: #1e002e;
}


</style>


<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script>
  $( function() {
    $( "#datepicker" ).datepicker({
      changeMonth: true,
      changeYear: true,
      dateFormate: 'mm/dd/yy'
    });
  } );
  $( function() {
	    $( "#datepicker1" ).datepicker({
	      changeMonth: true,
	      changeYear: true,
	      dateFormate: 'mm/dd/yy'
	    });
	} );
  
  $( function() {
	    $( "#datepicker3" ).datepicker({
	      changeMonth: true,
	      changeYear: true,
	      dateFormate: 'mm/dd/yy'
	    });
	} );
  
  function printContent(el) {
      var restorepage = document.body.innerHTML;
      var printcontent = document.getElementById(el).innerHTML;
      document.body.innerHTML = printcontent;
      window.print();
      document.body.innerHTML = restorepage;
  }
  
  </script>

</head>
<body>

	<tiles:insertAttribute name="header" />
	
		
		
			<tiles:insertAttribute name="body" />
		
	

			<tiles:insertAttribute name="footer" />
</body>
</html>