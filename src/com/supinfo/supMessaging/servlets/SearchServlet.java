package com.supinfo.supMessaging.servlets;

import com.supinfo.supMessaging.dao.DaoFactory;
import com.supinfo.supMessaging.entities.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Search")
public class SearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("Search.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String toSearch = req.getParameter("search");
        try {
            if (toSearch == null || toSearch.trim().isEmpty()) {
                throw new Exception("Empty search");
            }
            req.setAttribute("toSearch", toSearch);
            List<User> users = DaoFactory.getUserDao().searchByUsername(toSearch);
            if (users.size() == 0) {
                throw new Exception("No result");
            }
            req.setAttribute("results", users);
        } catch (Exception ex) {
            req.setAttribute("error", ex.getMessage());
        }
        req.getRequestDispatcher("Search.jsp").forward(req, resp);
    }
}
