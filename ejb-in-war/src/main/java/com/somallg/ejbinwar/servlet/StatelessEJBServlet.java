package com.somallg.ejbinwar.servlet;

import com.somallg.ejbinwar.ejb.stateless.StatelessEJB;

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

@WebServlet(urlPatterns = "/stateless")
public class StatelessEJBServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EJB
    private StatelessEJB statelessEJB;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final PrintWriter writer = response.getWriter();

        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    statelessEJB.decrement();
                    statelessEJB.increment();
                    writer.println(Thread.currentThread().getName() + " StatelessEJB " + statelessEJB.getCount());
                }
            }).start();
        }
    }
}
