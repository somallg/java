package com;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * Created by somallg on 7/27/14.
 */
public class TargetServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.getWriter().println("==== Inside TargetServlet ====");

        response.getWriter().println("servletPath " + request.getServletPath());

        response.getWriter().println("getParameter(pass)" + request.getParameter("pass"));

        Enumeration<String> attributeNames = request.getAttributeNames();

        while (attributeNames.hasMoreElements()) {
            String s = attributeNames.nextElement();
            response.getWriter().println(s + " = " + request.getAttribute(s));
        }

        response.getWriter().println("==== TargetServlet END =====");
    }

}
