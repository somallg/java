package com.somallg.core.impl.servlets;

import java.io.IOException;
import java.util.List;

import javax.jcr.RepositoryException;
import javax.servlet.ServletException;

import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.service.log.LogService;

import com.day.cq.wcm.foundation.Search;
import com.day.cq.wcm.foundation.Search.Hit;
import com.day.cq.wcm.foundation.Search.Result;

@SlingServlet(resourceTypes = "somallg/test", selectors = "search")
public class MyServlet extends SlingSafeMethodsServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3187712860555424583L;
	
	@Reference
	private LogService log;
	
	@Override
	protected void doGet(SlingHttpServletRequest request,
			SlingHttpServletResponse response) throws ServletException,
			IOException {
		Search search = new Search(request);
		
		String searchIn = request.getParameter("q");
		
		System.out.println("search in " + search.getSearchIn());
		System.out.println("search properties " + search.getSearchProperties());
		search.setQuery("geometrixx");
		try {
			Result result = search.getResult();
			List<Hit> hits = result.getHits();
			
			for (Hit h : hits) {
				System.out.println("Hit title = " + h.getTitle());
				System.out.println("Hit url = " + h.getURL());
			}
		} catch (RepositoryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
