<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>added</title>
</head>
<body>
<h3>
	added template  
</h3>

<br>
<li><s:message code="country.code"/>
<li><s:message code="country.flag"/>
<li><s:message code="country.name"/>
<br>

<P>  The time on the server is ${serverTime}. </P>

<img alt="" src="<c:url value="/img/img.jpg"/>">
</body>
</html>
