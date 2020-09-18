<%--
  Created by IntelliJ IDEA.
  User: Corey
  Date: 26/08/2020
  Time: 3:54 pm
  To change this template use File | Settings | File Templates.
--%>
<%@tag description="layout" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<jsp:include page="/WEB-INF/common/handle_action.jsp"/>
<jsp:include page="/WEB-INF/common/head.jsp"/>
<body>
<jsp:include page="/WEB-INF/common/header.jsp"/>
<main role="main">
    <jsp:include page="/WEB-INF/common/render_action.jsp"/>
    <jsp:doBody/>
</main>
<jsp:include page="/WEB-INF/common/footer.jsp"/>
<jsp:include page="/WEB-INF/common/scripts.jsp"/>
</body>
</html>