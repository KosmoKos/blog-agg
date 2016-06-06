<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<html>
<head>
    <meta http-equiv="content-type" content="text/html" charset="UTF-8">
    
    <title><tiles:getAsString name="title"/></title>
    
</head>

<body>
<tiles:insertAttribute name="body"/>

<br>
<br>
<div style="text-align: center;">

   <tiles:insertAttribute name="footer"/>

</div>

</body>
</html>