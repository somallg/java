package com;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Random;

/**
 * Created by duongtq on 7/27/14.
 */

@WebInitParam(name = "a", value = "b")
@WebServlet(value = "/test")
public class TestServlet extends HttpServlet {

    private Integer i = new Random().nextInt();

    public void doGet(final HttpServletRequest request,
                      final HttpServletResponse response) throws IOException, ServletException {
        //response.setContentType("text/html; charset=UTF-8");
        final PrintWriter out = response.getWriter();
        out.println(request.getRequestURL());
        out.println(request.getRequestURI());
        Enumeration<String> attributeNames = request.getAttributeNames();
        while (attributeNames.hasMoreElements()) {
            String s = attributeNames.nextElement();
            response.getWriter().println(s + " = " + request.getAttribute(s));
        }

        request.getRequestDispatcher("chapter7/hello.jsp").forward(request, response);

    }
}
