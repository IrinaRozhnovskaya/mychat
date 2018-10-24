<%--
  Created by IntelliJ IDEA.
  User: irina.rozhnovskaya
  Date: 10/8/2018
  Time: 2:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>My chat</title>
    <style>
        ul {
            list-style: none;
        }
    </style>
</head>
<body>
<s:form action="message" method="post">
    <s:textfield label="Enter your name" name="from"></s:textfield>
    <s:textfield label="Enter message" name="body"></s:textfield>
    <s:submit value="Send"></s:submit>
</s:form>
<ul>
    <c:forEach items="${messages}" var="message">
        <li>${message.from}: ${message.body} (${message.createdAt})</li>
    </c:forEach>
</ul>
</body>
</html>
