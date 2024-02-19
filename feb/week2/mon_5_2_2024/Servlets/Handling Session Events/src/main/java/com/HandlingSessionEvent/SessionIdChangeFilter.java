package com.HandlingSessionEvent;

//SessionIdChangeFilter.java
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/SessionIdChangeFilter") 
public class SessionIdChangeFilter implements Filter {

 @Override
 public void init(FilterConfig filterConfig) throws ServletException {
     
 }

 @Override
 public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
         throws IOException, ServletException {
     HttpServletRequest httpRequest = (HttpServletRequest) request;
     HttpSession session = httpRequest.getSession(false);

     if (session != null && isSessionIdChanged(httpRequest, session)) {
         handleSessionIdChangeEvent(httpRequest, session);
     }

     chain.doFilter(request, response);
 }

 @Override
 public void destroy() {
   
 }

 private boolean isSessionIdChanged(HttpServletRequest request, HttpSession session) {
     return !request.isRequestedSessionIdValid();
 }

 private void handleSessionIdChangeEvent(HttpServletRequest request, HttpSession session) {
    
     System.out.println("Session ID changed for session: " + session.getId());

     
     String newSessionId = request.getRequestedSessionId();
     System.out.println("New Session ID: " + newSessionId);

    
     request.setAttribute("newSessionId", newSessionId);
 }
}
