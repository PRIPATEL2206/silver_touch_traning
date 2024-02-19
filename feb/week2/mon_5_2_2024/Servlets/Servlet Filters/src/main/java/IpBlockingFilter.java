

import javax.servlet.Filter;
import javax.servlet.http.HttpFilter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlet Filter implementation class IpBlockingFilter
 */
public class IpBlockingFilter extends HttpFilter implements Filter {
	
	private Set<String> blockedIps;
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public IpBlockingFilter() {
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
		String ipAddress = request.getRemoteAddr();
        if (!blockedIps.contains(ipAddress)) {

            chain.doFilter(request, response);
        } else {
            response.getWriter().write("Access blocked for your IP address.");
        }
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		blockedIps = new HashSet<>();
        blockedIps.add("192.168.0.1");
        blockedIps.add("10.0.0.2");
	}

}
