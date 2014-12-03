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
 * Servlet Filter implementation class auth
 */
@WebFilter("/Auth/*")
public class auth implements Filter {

    /**
     * Default constructor. 
     */
    public auth() {
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
		
		HttpServletRequest lrequest = (HttpServletRequest)request;
		HttpServletResponse lresponse = (HttpServletResponse)response;
		
		try
		{
			if(lrequest.getSession().getAttribute(Constant.userSession) != null)
			{
				chain.doFilter(request, response);
			}
			else
			{
				lresponse.sendRedirect("../Login");
			}		
		}
		catch(Exception ex)
		{
			lresponse.sendRedirect("../Login");
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
