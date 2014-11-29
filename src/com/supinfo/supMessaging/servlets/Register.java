package com.supinfo.supMessaging.servlets;

import com.supinfo.supMessaging.dao.DaoFactory;
import com.supinfo.supMessaging.dao.UserDao;
import com.supinfo.supMessaging.entities.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

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

            if (request.getParameter("username") != null) {
                lUser.setUserName(request.getParameter("username"));
            }
			else
			{
				throw new Exception("Bad username !");
			}

            if ((request.getParameter("password") != null)
                    && (request.getParameter("password2") != null)
                    && (request.getParameter("password").equals(request.getParameter("password2")))) {
                lUser.setPassWord(request.getParameter("password").toString());
            }
			else
			{
				throw new Exception("Bad password !");
			}

            if (request.getParameter("mail") != null) {
                lUser.setMail(request.getParameter("mail").toString());
            }
			else
			{
				throw new Exception("Bad username !");
			}
			
			Date lDate = new Date();
			lUser.setInscriptionDate(lDate);
			
			UserDao luserDao = DaoFactory.getUserDao();
			luserDao.addUser(lUser);

            request.setAttribute("success", true);
            request.getRequestDispatcher("RegisterEnd.jsp").forward(request, response);
			
		} catch (Exception e) {
            request.setAttribute("success", false);
            request.setAttribute("error", e);
            request.getRequestDispatcher("RegisterEnd.jsp").forward(request, response);
		}
		
			
	}

}
