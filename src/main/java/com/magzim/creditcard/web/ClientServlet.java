package com.magzim.creditcard.web;

import com.magzim.creditcard.LoggerWrapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by max on 6/17/15.
 */
public class ClientServlet extends HttpServlet {
    private static final LoggerWrapper LOG = LoggerWrapper.get(ClientServlet.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (LOG.isDebug()) {
            LOG.debug("Redirect to clientList");
        }

//        request.getRequestDispatcher("/clientList.jsp").forward(request, response);
        response.sendRedirect("clientList.jsp");
    }
}
