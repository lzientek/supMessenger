package com.supinfo.supMessaging.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.supinfo.supMessaging.dao.DaoFactory;
import com.supinfo.supMessaging.dao.UserDao;
import com.supinfo.supMessaging.entities.User;
import com.supinfo.supMessaging.helpers.EmailValidator;

/**
 * Servlet implementation class ModifProfileServlet
 */
@WebServlet("/ModifProfile")
public class ModifProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifProfileServlet() {
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
		
		UserDao lUserDao = DaoFactory.getUserDao();
		User lUser = new User();
		
		lUser = lUserDao.findUserByUsername(request.getParameter("username"));
		
		boolean lDochange = false;
		
		if(request.getParameter("password") != null)
		{
			String lpassword = request.getParameter("password").replaceAll(" ","") ;
			if(!lpassword.equals("MyPasswordIsHide")&& !lpassword.equals("") &&( !lUser.checkPassword(request.getParameter("password"))))
			{
				lUser.setUnEncryptPassWord(lpassword);
				lDochange = true;
			}
		}
		
		if(!lUser.getMail().equals(request.getParameter("mail")))
		{
			EmailValidator lEmailValidator = new EmailValidator();
			if(lEmailValidator.validate(request.getParameter("mail")))
			{
				lUser.setMail(request.getParameter("mail"));
				lDochange = true;
			}
		}
		
		
		if(lDochange)
		{
			lUserDao.updateUser(lUser);
		}
		
		
		response.sendRedirect("Profile");
		
		
	}

}
