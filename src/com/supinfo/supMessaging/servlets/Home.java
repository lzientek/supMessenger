package com.supinfo.supMessaging.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.supinfo.supMessaging.dao.DaoFactory;
import com.supinfo.supMessaging.dao.MessageDao;
import com.supinfo.supMessaging.dao.UserDao;
import com.supinfo.supMessaging.entities.Message;
import com.supinfo.supMessaging.entities.User;

/**
 * Servlet implementation class Home
 */
@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
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
	
	protected void Service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		UserDao lUserDao = DaoFactory.getUserDao();
		MessageDao lMessageDao = DaoFactory.getMessageDao();
	
		request.setAttribute("nbUser", lUserDao.getNumberOfUser());
		request.setAttribute("nbPost", lMessageDao.getNumberOfMessage());
        request.getRequestDispatcher("Home.jsp").forward(request, response);
	}

}
