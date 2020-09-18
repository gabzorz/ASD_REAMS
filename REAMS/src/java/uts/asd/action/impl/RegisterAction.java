package uts.asd.action.impl;

import lombok.SneakyThrows;
import uts.asd.ReamsApplicationContext;
import uts.asd.action.UnauthenticatedAction;
import uts.asd.model.user.Role;
import uts.asd.model.user.User;
import uts.asd.servlet.filter.AuthenticatedFilter;
import uts.asd.util.AuthenticationUtil;
import uts.asd.util.Validator;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.ArrayList;

import static uts.asd.util.Validator.isNullOrEmpty;
import static uts.asd.util.Validator.matches;

public class RegisterAction extends UnauthenticatedAction {
    @SneakyThrows
    @Override
    protected void invoke(ServletContext application, HttpSession session, HttpServletRequest request, HttpServletResponse response) throws Exception {
        super.invoke(application, session, request, response);

        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String address = request.getParameter("address");
        String dob = request.getParameter("dob");
        String username = request.getParameter("username");
        String number = request.getParameter("number");
        String password = request.getParameter("password");


        //validation
/*        if (isNullOrEmpty(fname) || isNullOrEmpty(username) || isNullOrEmpty(password) || isNullOrEmpty(number)) {
            reject("You must supply a name, username, password and phone number in order to register.");
        }*/

        //validation
/*        if (!matches(Validator.Patterns.NAME_PATTERN, fname) || !matches(Validator.Patterns.USERNAME_PATTERN, username) || !matches(Validator.Patterns.PASSWORD_PATTERN, password) || !matches(Validator.Patterns.PHONE_NUMBER_PATTERN, number)) {
            //TODO: improve UX; provide specific errors
            reject("Your nominated name, username, password and / or phone number do not meet validation requirements.");
        }*/

        //gets instance of the application and checks if the user is already taken
        final ReamsApplicationContext ctx = ReamsApplicationContext.getInstance(application);
        final User existing = ctx.getUsers().findByUsername(username);

        if (existing != null) {
            request.setAttribute("username", username);
            reject("Sorry, that username is already taken.");
        }

        // creates a new user in the database
        final User user = ctx.getUsers().create(new User(fname, lname, username, AuthenticationUtil.hash(password), dob, address, number, Role.CUSTOMER, true));

        if (user == null) {
            request.setAttribute("username", username);
            reject("Unable to register an account; please try again.");
        }


        //sets the session
        AuthenticationUtil.authenticate(session, user);

        message = String.format("Registration successful. Welcome %s", user.getUsername());

    }
}

