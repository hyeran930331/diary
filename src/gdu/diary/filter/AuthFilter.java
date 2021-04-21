package gdu.diary.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class AuthFilter
 */
@WebFilter("/auth/*") // 1encoding filter 2 authfilter 3 index controller 4authfilter 5encodingfilter
public class AuthFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		System.out.println("__________@WebFilter(''/auth/'') AuthFilter doFilter");
		System.out.println("// ''/auth/*''문자로 시작하는 요청이 들어오면 redirect");
		
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		HttpSession session = httpRequest.getSession();
		if(session.getAttribute("sessionMember") == null) {
			HttpServletResponse httpResponse = (HttpServletResponse)response;
			httpResponse.sendRedirect(httpRequest.getContextPath()+"/login");
			return; // 새로운 요청발생으로 메소드 종료
		}
		chain.doFilter(request, response);
	}

	public AuthFilter() {
	}
	
	public void destroy() {
	}
	
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
