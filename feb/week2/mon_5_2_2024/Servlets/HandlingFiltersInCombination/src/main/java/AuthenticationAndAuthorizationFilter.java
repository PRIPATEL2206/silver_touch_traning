

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class AuthenticationAndAuthorizationFilter
 */
@WebFilter("/login")
public class AuthenticationAndAuthorizationFilter extends HttpFilter implements Filter {
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public AuthenticationAndAuthorizationFilter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String role = request.getParameter("role");
        if(password.isEmpty() || password.isBlank() || username.isBlank() || username.isEmpty() || role.isBlank() || role.isEmpty())
        {
        	chain.doFilter(request, response);
        }
        else if (password.equals("admin123") && username.equals("admin")) {
        	if(role.equals("admin"))
        	{
        		HttpSession mysession = httpRequest.getSession();
            	mysession.setAttribute("user", username);
            	mysession.setAttribute("role", role);
                chain.doFilter(request, response);
        	}
        	else {
                httpResponse.sendRedirect(httpRequest.getContextPath() + "/access-denied.jsp");
            }
        	
        }
        else {
        	httpResponse.sendRedirect(httpRequest.getContextPath() + "/login.jsp?error=2");
        }

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
