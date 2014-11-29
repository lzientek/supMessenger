package com.supinfo.supMessaging.servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.supinfo.supMessaging.dao.DaoFactory;
import com.supinfo.supMessaging.dao.UserDao;
import com.supinfo.supMessaging.dao.jpa.JpaUserDao;
import com.supinfo.supMessaging.entities.User;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
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
			
			User lUser = new User();
			
			if(request.getAttribute("username") != null)
			{
				lUser.setUserName(request.getAttribute("username").toString());
			}
			else
			{
				throw new Exception("Bad username !");
			}
			
			if((request.getAttribute("password") != null) && (request.getAttribute("password2") != null) && (request.getAttribute("password").equals(request.getAttribute("password2"))) )
			{
				lUser.setPassWord(request.getAttribute("username").toString());
			}
			else
			{
				throw new Exception("Bad password !");
			}
			
			if(request.getAttribute("mail") != null)
			{
				lUser.setMail(request.getAttribute("mail").toString());
			}
			else
			{
				throw new Exception("Bad username !");
			}
			
			Date lDate = new Date();
			lUser.setInscriptionDate(lDate);
			
			UserDao luserDao = DaoFactory.getUserDao();
			luserDao.addUser(lUser);
						
			request.setAttribute("Success", true);
			request.getRequestDispatcher("RegisterEnd.jsp").forward(request, response);	
			
		} catch (Exception e) {			
			request.setAttribute("Success", false);
			request.setAttribute("Error", e);
			request.getRequestDispatcher("RegisterEnd.jsp").forward(request, response);
		}
		
			
	}

}
