<%--
  Created by IntelliJ IDEA.
  User: Corey
  Date: 26/08/2020
  Time: 3:56 pm
  To change this template use File | Settings | File Templates.
--%>
<%@page import="uts.asd.Constants"%>
<%@ page import="uts.asd.util.AuthenticationUtil" %>
<%@ page import="java.text.DecimalFormat" %>
<%@ page import="java.util.*" %>
<%
    final boolean authenticated = AuthenticationUtil.isAuthenticated(session);
    final String template = authenticated ? "authenticated" : "unauthenticated";
    final String header = String.format("../../WEB-INF/common/header/%s.jsp", template);
%>

<header>
    <div class="navbar navbar-dark bg-dark box-shadow">
        <div class="container d-flex justify-content-between">
            <%
                final Map<String, String> paths = new LinkedHashMap<>();

                paths.put(Constants.APPLICATION_NAME, Constants.path(false));

                final String current = request.getServletPath().replace(Constants.path(false), "");
                final String[] segments = current.split("/");

                for (int index = 1; index < segments.length - 1; index++) {
                    final String segment = segments[index];
                    final String[] components = new ArrayList<>(Arrays.asList(segments).subList(1, index + 1)).toArray(new String[0]);
                    final String path = Constants.path(false, components);
                    paths.put(segment, path);
                }
            %>

            <div>
                <%
                    final Iterator<Map.Entry<String, String>> entries = paths.entrySet().iterator();

                    while (entries.hasNext()) {
                        final Map.Entry<String, String> entry = entries.next();
                        final String title = entry.getKey();
                        final String url = entry.getValue();
                        final boolean end = !entries.hasNext();

                %>
                <span class="navbar-brand align-items-center"><% if (!end) { %><a href="<%= url %>"><% } %><strong><%= title %></strong><% if (!end) { %></a><% } %><span class="text-white"><%= end ? "" : "&gt;"%></span></span>
                <%
                    }
                %>
                <div class="text-white">
                    <jsp:include page="<%= header %>"/>
                </div>
        </div>
        </div>
    </div>
</header>