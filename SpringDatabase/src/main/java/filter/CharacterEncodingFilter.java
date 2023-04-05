package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharacterEncodingFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, 
			FilterChain chain) throws IOException, ServletException {
		System.out.println("필터에서 처리중입니다.");
		
		request.setCharacterEncoding("EUC-KR");
	
		System.out.println("처리가 끝났습니다.. 다음 필터로 이동합니다.");
	
		chain.doFilter(request, response); // filter 하나라고 보지 않으므로 다음 chain으로 보내주는 과정이 필요
		
	}
	
	@Override
	public void destroy() {
	
	}
	
	
}
