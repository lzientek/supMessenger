package com.supinfo.supMessaging.servlets;

import com.supinfo.supMessaging.dao.DaoFactory;
import com.supinfo.supMessaging.entities.Message;
import com.supinfo.supMessaging.entities.User;
import com.supinfo.supMessaging.helpers.Constant;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class Home
 */
@WebServlet("/Chat")
public class ChatServlet extends HttpServlet {

    private User contact;
    private User actualUser;


    private void getValues(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //get messages
        try {

            if (contact != null) {
                req.setAttribute("selectedContact", contact);
                List<Message> messages = DaoFactory.getMessageDao().getMessagesByUsers(actualUser, contact);
                if (messages.size() == 0) {
                    throw new Exception("No Message");
                }
                req.setAttribute("messages", messages);

            }

        } catch (Exception ex) {
            req.setAttribute("error", ex.getMessage());
        }
    }

    private void getUsers(HttpServletRequest req) throws Exception {
        actualUser = DaoFactory.getUserDao().getUserByIdWithContacts((Long) req.getSession().getAttribute(Constant.userSession));
        req.setAttribute("user", actualUser);

        if (req.getParameter("contactId") != null) {
            Long contactId = Long.parseLong(req.getParameter("contactId"));
            contact = DaoFactory.getUserDao().getUserById(contactId);
            if (contact == null) {
                throw new Exception("Invalide contact id");
            }
        } else {
            throw new Exception("Select a contact");
        }

    }

    /**
     * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            getUsers(request);
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
        }

        getValues(request, response);
        request.getRequestDispatcher("Chat.jsp").forward(request, response);
    }

    /**
     * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            getUsers(request);
            String msg = request.getParameter("message");
            if (msg == null || msg.trim().isEmpty()) {
                throw new Exception("Empty message!");
            }
            Message message = new Message();
            message.setMessage(msg);
            message.setRecipient(contact);
            message.setTransmitter(actualUser);
            DaoFactory.getMessageDao().sendMessage(message);
        } catch (Exception e) {
            request.setAttribute("sendError", e.getMessage());
        }

        getValues(request, response);

        request.getRequestDispatcher("Chat.jsp").forward(request, response);
    }


}
