package uts.asd.servlet.filter;

import uts.asd.model.user.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class AuthenticatedStaffFilter extends AuthenticatedFilter{

    @Override
    protected boolean isAuthenticated(HttpServletRequest request, HttpSession session, User user){
        if(!super.isAuthenticated(request,session,user)){
            return false;
        }

        if(user==null){
            return false;
        }

        return user.getRole().isStaff();

    }
}
