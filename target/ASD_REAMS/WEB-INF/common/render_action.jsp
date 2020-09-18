<%--
  Created by IntelliJ IDEA.
  User: Corey
  Date: 26/08/2020
  Time: 3:56 pm
  To change this template use File | Settings | File Templates.
--%>
<%@page import="uts.asd.action.Action"%>
<%
    final Action action = (Action) request.getAttribute(Action.KEY);

    if (action != null) {
        out.println(action.render());
    }
%>
