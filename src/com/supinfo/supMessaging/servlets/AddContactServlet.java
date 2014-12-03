package com.supinfo.supMessaging.servlets;

import com.supinfo.supMessaging.dao.DaoFactory;
import com.supinfo.supMessaging.entities.User;
import com.supinfo.supMessaging.helpers.Constant;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Auth/AddContact")
public class AddContactServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            Long id = Long.parseLong(req.getParameter("contactId"));
            if (id == null || id == 0) {
                throw new Exception("empty id!");
            }

            User newContact = DaoFactory.getUserDao().getUserById(id);
            User actualUser = DaoFactory.getUserDao().getUserById((Long) req.getSession().getAttribute(Constant.userSession));

            DaoFactory.getContactsDao().addContacts(actualUser, newContact);
            resp.sendRedirect("Home");
        } catch (Exception ex) {
            req.setAttribute("error", ex.getMessage());
            req.getRequestDispatcher("Search.jsp").forward(req, resp);
        }
    }
}
