<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h3>
	template  
</h3>

<P>  The time on the server is ${serverTime}. </P>
<br>
<li><s:message code="country.code"/>
<li><s:message code="country.flag"/>
<li><s:message code="country.name"/>
<br>
${first}
<br>
${second}
<br>
<c:forEach var="resultList" items="${resultList}">
	<li><c:out value="${resultList.name}"/>,<c:out value="${resultList.addr}"/>
</c:forEach>
<br>
<img alt="" src="<c:url value="/img/img.jpg"/>">
</body>
</html>
