<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--
  Created by IntelliJ IDEA.
  User: irina.rozhnovskaya
  Date: 10/8/2018
  Time: 2:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<!DOCTYPE html>
<html>
   <head>
       <title>My chat</title>
   </head>

   <body>
   <form action="message">

       <input type="text" to="to"/>
       <input type="text" body="body"/>
       <input type="submit" value="Submit"/>
       <s:property value="messages"/>!
   </form>


    </body>
</html>
