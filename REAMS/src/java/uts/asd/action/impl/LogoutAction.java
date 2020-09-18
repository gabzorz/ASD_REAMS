package uts.asd.action.impl;

import uts.asd.action.AuthenticatedAction;
import uts.asd.util.AuthenticationUtil;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutAction extends AuthenticatedAction {

    protected void invoke(ServletContext app, HttpSession session, HttpServletRequest req, HttpServletResponse response) throws Exception {
        super.invoke(app, session, req, response);

        AuthenticationUtil.unauthenticate(session);
        type = MessageType.SUCCESS;
        message = "You have been successfully logged out!";

    }

}
