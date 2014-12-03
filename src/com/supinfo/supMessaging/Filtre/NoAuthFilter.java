package com.supinfo.supMessaging.Filtre;

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

import com.supinfo.supMessaging.helpers.Constant;

/**
 * Servlet Filter implementation class NoAuthFilter
 */
@WebFilter(urlPatterns={"/Home","/Login","/RegisterEnd","/RegisterPage"})
public class NoAuthFilter implements Filter {

    /**
     * Default constructor. 
     */
    public NoAuthFilter() {
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
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		HttpServletRequest lrequest = (HttpServletRequest)request;
		HttpServletResponse lresponse = (HttpServletResponse)response;
		
		try
		{
			if(lrequest.getSession().getAttribute(Constant.userSession) == null)
			{
				chain.doFilter(request, response);
			}
			else
			{
				lresponse.sendRedirect("Auth/Home");
			}		
		}
		catch(Exception ex)
		{
			lresponse.sendRedirect("Auth/Home");
		}

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
