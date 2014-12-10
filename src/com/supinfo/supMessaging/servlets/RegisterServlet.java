package com.supinfo.supMessaging.servlets;

import com.supinfo.supMessaging.dao.DaoFactory;
import com.supinfo.supMessaging.dao.UserDao;
import com.supinfo.supMessaging.dao.jpa.JpaUserDao;
import com.supinfo.supMessaging.entities.User;
import com.supinfo.supMessaging.helpers.Constant;
import com.supinfo.supMessaging.helpers.EmailValidator;

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
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("RegisterPage.jsp").forward(request, response);

    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        try {
			
			User lUser = new User();

            if (request.getParameter("username") != null && !request.getParameter("username").replaceAll(" ", "").equals("") ) {
            	
            	UserDao lUserDao = DaoFactory.getUserDao();
            	if(lUserDao.findUserByUsername(request.getParameter("username")) == null)
            	{
            		lUser.setUserName(request.getParameter("username"));
            	}
            	else
            	{
            		throw new Exception("User already exist !");
            	}
            }
			else
			{
				throw new Exception("Bad username !");
			}

            if ((request.getParameter("password") != null && !request.getParameter("password").replaceAll(" ", "").equals(""))
                    && (request.getParameter("password2") != null)
                    && (request.getParameter("password").equals(request.getParameter("password2")))) {                    	
                lUser.setUnEncryptPassWord(request.getParameter("password"));
            }
			else
			{
				throw new Exception("Bad password !");
			}

            if (request.getParameter("mail") != null) {
            	EmailValidator lEmail = new EmailValidator();
                if (lEmail.validate(request.getParameter("mail"))) {
            		lUser.setMail(request.getParameter("mail"));
            	}
            	else
    			{
                    throw new Exception("Bad mail !");
                }
            }
			else
			{
                throw new Exception("Bad mail !");
            }
            
            
            if(request.getParameter("firstName") != null && !request.getParameter("firstName").replaceAll(" ", "").equals("") )
            {
            	lUser.setFirstname(request.getParameter("firstName").replaceAll(" ", ""));
            }
            else
            {
            	 throw new Exception("Bad First Name !");
            }

            
            if(request.getParameter("lastName") != null && !request.getParameter("lastName").replaceAll(" ", "").equals("") )
            {
            	lUser.setLastname(request.getParameter("lastName").replaceAll(" ", ""));
            }
            else
            {
            	 throw new Exception("Bad Last Name !");
            }
			
			Date lDate = new Date();
			lUser.setInscriptionDate(lDate);
			
			UserDao luserDao = DaoFactory.getUserDao();
			luserDao.addUser(lUser);
			
			request.getSession().setAttribute(Constant.userSession, lUser.getId());
			
            response.sendRedirect("Auth/RegisterEnd.jsp");
			
		} catch (Exception e) {
            request.setAttribute("success", false);
            request.setAttribute("error", e.getMessage());
            
            request.setAttribute("Rusername",request.getParameter("username"));
            request.setAttribute("Rpassword",request.getParameter("password"));
            request.setAttribute("Rpassword2",request.getParameter("password2"));
            request.setAttribute("Rmail",request.getParameter("mail"));
            request.setAttribute("RfirstName",request.getParameter("firstName"));
            request.setAttribute("RlastName",request.getParameter("lastName"));
            
            request.getRequestDispatcher("RegisterPage.jsp").forward(request, response);
		}

    }

}
