package com.tsystems.train.handler;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthenticationHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    @Override
    public String determineTargetUrl(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String role = auth.getAuthorities().toString();
        String targetUrl = "";
        if(role.contains("ROLE_MANAGER")) {
            targetUrl = "/stations";
        } else if(role.contains("ROLE_USER")) {
            targetUrl = "/";
        }
        return targetUrl;
    }
}
