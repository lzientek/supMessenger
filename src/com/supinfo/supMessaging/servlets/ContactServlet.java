package com.supinfo.supMessaging.servlets;

import com.supinfo.supMessaging.dao.DaoFactory;
import com.supinfo.supMessaging.entities.Message;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Logout
 */
@WebServlet(urlPatterns={"/Contact","/Auth/Contact"})
public class ContactServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("Contact.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String val = req.getParameter("message");
            if (val == null || val.trim().isEmpty())
                throw new Exception("empty message");
            Message msg = new Message();
            msg.setMessage(val);
            DaoFactory.getMessageDao().sendMessage(msg);
            req.setAttribute("success", true);
        } catch (Exception ex) {
            req.setAttribute("error", ex.getMessage());
        }
        req.getRequestDispatcher("Contact.jsp").forward(req, resp);
    }
}
