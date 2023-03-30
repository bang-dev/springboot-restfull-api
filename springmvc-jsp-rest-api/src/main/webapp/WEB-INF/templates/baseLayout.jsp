<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
<head>
    <title><tiles:getAsString name="title"/></title>
    <link type="text/css" rel="stylesheet" href="<c:url value="/resources/static/css/styles.css"/>"/>
</head>
<body>
<div id="header">
    <tiles:insertAttribute name="header"/>
</div>
<div id="content">
    <tiles:insertAttribute name="content"/>
</div>
<div id="footer">
    <tiles:insertAttribute name="footer"/>
</div>
</body>
</html>
