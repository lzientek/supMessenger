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
import com.supinfo.supMessaging.helpers.Constant;
import com.supinfo.supMessaging.helpers.CryptoHelper;
import com.supinfo.supMessaging.helpers.EmailValidator;

/**
 * Servlet implementation class ProfileServlet
 */
@WebServlet("/Profile")
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileServlet() {
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
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		UserDao lUserDao = DaoFactory.getUserDao();
		User lUser = new User();
			
		
		lUser = lUserDao.getUserById(Long.parseLong(request.getSession().getAttribute(Constant.userSession).toString()));
		
		request.setAttribute("username", lUser.getUserName());
		request.setAttribute("password", "MyPasswordIsHide");
		request.setAttribute("mail", lUser.getMail());
		request.setAttribute("urlGravatar", CryptoHelper.getUrlGravatar(lUser.getMail()));
			
		request.getRequestDispatcher("Profile.jsp").forward(request, response);

	}
	

}
