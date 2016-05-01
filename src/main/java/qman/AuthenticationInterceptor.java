package qman;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by sukhi on 29-03-2016.
 */

public class AuthenticationInterceptor extends HandlerInterceptorAdapter {
    boolean status;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // Avoid a redirect loop for some urls
        if (!request.getRequestURI().equals("/") && !request.getRequestURI().equals("/login")) {
            System.out.println("Inside Interceptor if condition");
            Object userData = (Object)request.getSession().getAttribute("UserSessionId");
            if (userData == null) {
                response.sendRedirect("/");
                status = false;
            }
        }
        else {
            System.out.println("Inside Interceptor else condition");
            status = true;
        }
        return status;
    }
}
