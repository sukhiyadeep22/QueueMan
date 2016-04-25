package qman;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by sukhi on 29-03-2016.
 */

public class AuthenticationInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if(request.getSession().getMaxInactiveInterval() >= 1800)
        {
            request.getSession().invalidate();
            response.sendRedirect("/");
        }

        request.getSession().setMaxInactiveInterval(1800);

        // Avoid a redirect loop for some urls
        if (!request.getRequestURI().equals("/") && !request.getRequestURI().equals("/login") ) {
            Object userData = request.getSession().getAttribute("UserSessionId");
            if (userData == null) {
                response.sendRedirect("/");
                return false;
            }
        }
        return true;
    }
}
