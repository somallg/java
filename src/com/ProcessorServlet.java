package com;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by somallg on 7/27/14.
 */
public class ProcessorServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().println(request.getMethod());
        request.getSession().setAttribute("planet", "earth");
        request.getSession().invalidate();
        System.out.println("After session invalidate");
        System.out.println(request.getSession().getAttribute("planet"));
        request.getSession().removeAttribute("planet");
        request.getSession().setAttribute("planet", "venus");
        request.setAttribute("planet", "earth");
        request.setAttribute("planet", "venus");

        response.getWriter().close();
        // redirect after the response is committed
        response.sendRedirect("http://www.google.com");
    }
}
