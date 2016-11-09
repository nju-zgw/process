package com.springapp.mvc.auth;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by WH on 2016/11/8.
 */
public class AuthSuccessHandlerImpl implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess
            (HttpServletRequest request,
             HttpServletResponse response,
             Authentication authentication) throws IOException, ServletException {
        response.sendRedirect(request.getContextPath()+"/loginSuccess");
    }
}
