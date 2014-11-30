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

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("Home.jsp").forward(request, response);

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub

        try {

            UserDao lUserDao = DaoFactory.getUserDao();
            User lUser = lUserDao.findUserByUsername(request.getParameter("username"));

            if (lUser != null) {
                if (lUser.checkPassword(request.getParameter("password"))) {
                    //on pose la session id!
                    request.getSession().setAttribute("userId", lUser.getId());

                    request.getRequestDispatcher("HomeConnected.jsp").forward(request, response);

                } else {
                    throw new Exception("Bad password !");
                }
            } else {
                throw new Exception("Bad Login !");
            }

        } catch (Exception e) {
            request.setAttribute("error", e);
        }

    }

}