package br.com.Filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@WebFilter(urlPatterns = "*.jsf")
public class AuthFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession(false);
		
		Object usuarioLogado = (session != null) ? session.getAttribute("usuarioLogado") : null;
		
		String url = req.getRequestURI();
		
		if(usuarioLogado == null && !url.endsWith("loginPage.jsf") && !url.endsWith("registerPage.jsf") && !url.contains("javax.faces.resource")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/loginPage.jsf");
			dispatcher.forward(request, response);
		}
		else {
			chain.doFilter(request, response);
		}
		
		
	}

	@Override
	public void destroy() {
		
		
	}

	
	
}
