package com.supinfo.supMessaging.servlets;

import com.supinfo.supMessaging.dao.DaoFactory;
import com.supinfo.supMessaging.entities.Message;
import com.supinfo.supMessaging.entities.User;
import com.supinfo.supMessaging.helpers.Constant;
import com.supinfo.supMessaging.helpers.ValueComparator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Servlet implementation class Home
 */
@WebServlet("/Auth/Home")
public class HomeConnectedServlet extends HttpServlet {

    /**
     * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = DaoFactory.getUserDao().getUserById((Long) request.getSession().getAttribute(Constant.userSession));
        List<Message> messages = DaoFactory.getMessageDao().getMessageAccueil(user);

        Map<Long, Message> result = new HashMap<Long, Message>();
        for (int i = messages.size() - 1; i >= 0; i--) {
            Long notMyId = user.getId() == messages.get(i).getRecipient().getId()
                    ? messages.get(i).getTransmitter().getId() : messages.get(i).getRecipient().getId();

            result.put(notMyId, messages.get(i));
        }
        ValueComparator bvc = new ValueComparator(result);
        TreeMap<Long, Message> sorted_map = new TreeMap<Long, Message>(bvc);
        sorted_map.putAll(result);
        request.setAttribute("result", sorted_map);
        request.getRequestDispatcher("Home.jsp").forward(request, response);
    }


    /**
     * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


}
