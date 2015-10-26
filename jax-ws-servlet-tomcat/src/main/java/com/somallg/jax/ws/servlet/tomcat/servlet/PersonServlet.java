package com.somallg.jax.ws.servlet.tomcat.servlet;

import com.somallg.jax.ws.servlet.tomcat.domain.Person;
import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by somallg on 11/18/2014.
 */
public class PersonServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ObjectMapper objectMapper = new ObjectMapper();

        Person p = new Person();

        p.setName("Lala");
        p.setAge(23);

        objectMapper.writeValue(response.getOutputStream(), p);
    }
}
