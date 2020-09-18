package uts.asd.servlet.filter;

import lombok.SneakyThrows;
import uts.asd.util.AuthenticationUtil;
import uts.asd.Constants;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class UnauthenticatedFilter implements Filter {

    private static final String REDIRECTION_PATH = Constants.path(true);

    @Override
    @SneakyThrows
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        final HttpServletRequest req = (HttpServletRequest) request;
        final HttpServletResponse res = (HttpServletResponse) response;

        final HttpSession session = req.getSession();
        final boolean authenticated = AuthenticationUtil.isAuthenticated(session);

        if (authenticated) {
            res.sendRedirect(REDIRECTION_PATH);
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override public void init(FilterConfig filterConfig) {}

    @Override public void destroy() {}
}
