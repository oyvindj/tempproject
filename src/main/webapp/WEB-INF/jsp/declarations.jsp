<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String context = "/webresources";
%>

<link rel="stylesheet" href="<%=context%>/css/tine.css" media="screen">
<link rel="stylesheet" href="<%=context%>/css/tine_print.css" media="print">

<!-- overLIB (c) Erik Bosrup -->
<script type="text/javascript" src="<%=context%>/media/javascript/overlib.js"></script>

<script type="text/javascript" src="../javascript/starterkit.js"></script>

<div id="overDiv" style="position:absolute; visibility:hidden; z-index:1000;"></div>

<%-- DECLARATIONS --%>
<c:set scope="application" var="dateformatShort" value="dd.MM.yy"/>
<c:set scope="application" var="datePattern" value="dd.MM.yyyy"/>
<c:set scope="application" var="dateTimePattern" value="dd.MM.yyyy HH:mm:ss"/>
<c:set scope="application" var="districtPattern" value="###"/>
<c:set scope="application" var="advisorPattern" value="##"/>
<c:set scope="application" var="numControlsPattern" value="##"/>
<c:set scope="application" var="numAnimalsPattern" value="##"/>


