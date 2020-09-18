package uts.asd.action.impl;

import uts.asd.action.UnauthenticatedAction;
import uts.asd.model.user.User;
import uts.asd.util.AuthenticationUtil;
import uts.asd.ReamsApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static uts.asd.util.Validator.isNullOrEmpty;

public class LoginAction extends UnauthenticatedAction {

    @Override
    protected void invoke(ServletContext application, HttpSession session, HttpServletRequest request, HttpServletResponse response) throws Exception {
        super.invoke(application, session, request, response);

        //inputted data
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //validation
        if (isNullOrEmpty(username) || isNullOrEmpty(password)) {
            reject("You must supply a username and password in order to login.");
        }

        //finds the user
        final ReamsApplicationContext ctx = ReamsApplicationContext.getInstance(application);
        final User user = ctx.getUsers().findByUsername(username);

        //checks if the user is found
        if (user == null) {
            request.setAttribute("username", username);
            reject("Incorrect username or password");
        }

        //checks if the user is enabled or disabled
        if (!user.isEnabled()) {
            request.setAttribute("username", username);
            reject("This account has been disabled.");
        }

        //verifies if the inputted password matches the hashed password
        if (!AuthenticationUtil.verify(password, user.getPassword())) {
            request.setAttribute("username", username);
            reject("Incorrect username or password");
        }

        AuthenticationUtil.authenticate(session, user);

        message = String.format("Login successful. Welcome, %s", user.getUsername());
        //TODO: add login redirection
    }}