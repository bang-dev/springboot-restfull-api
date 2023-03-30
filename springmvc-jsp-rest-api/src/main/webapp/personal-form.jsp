
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<tiles:insertDefinition name="baseLayout">
<tiles:putAttribute name="title" value="Home" />
 <tiles:putAttribute name="content">
     <form action="<c:url value='personal-form.jsp'/>" method="post">
         <input type="hidden" name="action" value="create"/>
         <input type="text" name="firstName" placeholder="First name"/>
         <input type="text" name="lastName" placeholder="Last name"/>
         <input type="text" name="major" placeholder="Major"/>
         <button type="submit">Create</button>`
     </form>
</tiles:putAttribute>
</tiles:insertDefinition>



