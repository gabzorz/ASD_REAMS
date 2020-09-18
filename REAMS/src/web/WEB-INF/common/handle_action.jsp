<%--
  Created by IntelliJ IDEA.
  User: Corey
  Date: 26/08/2020
  Time: 3:55 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="uts.asd.action.ActionProcessor" %>
<%@ page import="uts.asd.ReamsApplicationContext" %>
<%
    final ReamsApplicationContext context = ReamsApplicationContext.getInstance(application);
    final ActionProcessor processor = context.getProcessor();
    processor.process(request, response);
%>
