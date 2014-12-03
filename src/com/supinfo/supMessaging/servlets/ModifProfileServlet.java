package com.supinfo.supMessaging.servlets;

import com.supinfo.supMessaging.dao.DaoFactory;
import com.supinfo.supMessaging.dao.UserDao;
import com.supinfo.supMessaging.entities.User;
import com.supinfo.supMessaging.helpers.EmailValidator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class ModifProfileServlet
 */
@WebServlet("/Auth/ModifProfile")
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
		
		if(!lUser.getFirstname().equals(request.getParameter("firstName")))
		{
			String lfName = request.getParameter("firstName").replaceAll(" ","") ;
			if(!lfName.equals(""))
			{
				lUser.setFirstname(lfName);
				lDochange = true;
			}
		}
		
		if(!lUser.getFirstname().equals(request.getParameter("lastName")))
		{
			String lLName = request.getParameter("lastName").replaceAll(" ","") ;
			if(!lLName.equals(""))
			{
				lUser.setLastname(lLName);
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
