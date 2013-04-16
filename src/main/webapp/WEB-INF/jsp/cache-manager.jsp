<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page
        language="java"
        contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"
        isErrorPage="false" errorPage="/common/errors/error.jsp"
        %>

<jsp:include flush="true" page="declarations.jsp"/>
<jsp:useBean id="message" scope="request" type="java.lang.String"/>


<h2><c:out value="${message}"/></h2>
