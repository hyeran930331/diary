package gdu.diary.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/*")
public class EncodingFilter implements Filter {

		
    public EncodingFilter() {
	}

    //필터 종료시
	public void destroy() {
		
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	System.out.println("__________@WebFilter(''/*'') EncodingFilter  doFilter");
	System.out.println("// 모든 요청이 들어오면 redirect");
	
		request.setCharacterEncoding("utf-8");
		chain.doFilter(request, response);
	}

	//필터 시작시
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
