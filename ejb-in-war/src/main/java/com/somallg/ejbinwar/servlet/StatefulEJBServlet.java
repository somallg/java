package com.somallg.ejbinwar.servlet;

import com.somallg.ejbinwar.ejb.stateful.StatefulEJB;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by somallg on 11/20/14.
 */

@WebServlet(urlPatterns = "/stateful")
public class StatefulEJBServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
    private StatefulEJB statefulEJB;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final PrintWriter writer = response.getWriter();

        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    statefulEJB.decrement();
                    statefulEJB.increment();
                    writer.println(Thread.currentThread().getName() + " StatefulEJB " + statefulEJB.getCount());
                }
            }).start();
        }
    }
}
