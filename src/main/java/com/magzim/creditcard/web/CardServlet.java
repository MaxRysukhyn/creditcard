package com.magzim.creditcard.web;

import com.magzim.creditcard.LoggerWrapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by max on 6/22/15.
 */
public class CardServlet extends HttpServlet {
    private static final LoggerWrapper LOG = LoggerWrapper.get(CardServlet.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (LOG.isDebug()) {
            LOG.debug("Redirect to cardList");
        }

        request.getRequestDispatcher("/cardList.jsp").forward(request, response);
//        response.sendRedirect("cardServlet.jsp");
    }
}
