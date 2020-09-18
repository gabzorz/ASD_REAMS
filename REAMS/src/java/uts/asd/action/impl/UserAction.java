package uts.asd.action.impl;

import lombok.SneakyThrows;
import uts.asd.ReamsApplicationContext;
import uts.asd.action.AuthenticatedAction;
import uts.asd.model.user.Role;
import uts.asd.model.user.User;
import uts.asd.util.AuthenticationUtil;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static uts.asd.util.Validator.isNullOrEmpty;

public class UserAction extends AuthenticatedAction {

    protected void invoke(ServletContext application, HttpSession session, HttpServletRequest request, HttpServletResponse response) throws Exception {
        super.invoke(application, session, request, response);

        final String type = request.getParameter("type");

        if (isNullOrEmpty(type)) {
            return;
        }

        final ReamsApplicationContext ctx = ReamsApplicationContext.getInstance(application);
        final User user = AuthenticationUtil.user(session);

        switch (type.toLowerCase()) {
            case "update": update(ctx, user, request); break;
            default: break;
        }
    }


    @SneakyThrows
    private void update(ReamsApplicationContext ctx, User user, HttpServletRequest request) {
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String username = request.getParameter("username");
        String dob = request.getParameter("dob");
        String address = request.getParameter("address");
        String number = request.getParameter("number");
        boolean enabled = isNullOrEmpty(request.getParameter("disable"));

        //validation
/*        if (isNullOrEmpty(fname) || isNullOrEmpty(lname) || isNullOrEmpty(username) || isNullOrEmpty(number)) {
            reject("You can't leave a field empty.");
        }*/

/*        //validation
        if (!matches(Validator.Patterns.NAME_PATTERN, name) || !matches(Validator.Patterns.USERNAME_PATTERN, username) || !matches(Validator.Patterns.PHONE_NUMBER_PATTERN, phone)) {
            reject("Your nominated name, username or phone number do not meet validation requirements.");
        }*/


        //updates the object
        user.setFname(fname);
        user.setLname(lname);
        user.setUsername(username);
        user.setDob(dob);
        user.setAddress(address);
        user.setNumber(number);
        user.setEnabled(enabled);

        //updates MongoDB
        ctx.getUsers().update(user);

        message = "Successfully updated account";
    }
}