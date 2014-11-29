package com.supinfo.supMessaging.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.supinfo.supMessaging.dao.DaoFactory;
import com.supinfo.supMessaging.dao.UserDao;
import com.supinfo.supMessaging.dao.jpa.JpaUserDao;
import com.supinfo.supMessaging.entities.User;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
			
			UserDao lUserDao = DaoFactory.getUserDao();			
			User lUser = new User();
			lUser = lUserDao.findUserByUsername(request.getParameter("username"));
			
			if(lUser != null)
			{
				if(lUser.checkPassword(request.getParameter("password")))
				{
					HttpSession lSession = request.getSession();
					lSession.setAttribute("Username", lUser.getUserName());
					
					request.getRequestDispatcher("/HomeConnected.jsp").forward(request, response);
					
				}
				else
				{
					throw new Exception("Bad password !"); 
				}	
			}
			else
			{
				throw new Exception("Bad Login !"); 
			}
			
		} catch (Exception e) {
			request.setAttribute("error", e);
		}
		
	}

}
