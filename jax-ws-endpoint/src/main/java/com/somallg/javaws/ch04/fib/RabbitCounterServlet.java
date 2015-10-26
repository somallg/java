package com.somallg.javaws.ch04.fib;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.http.HTTPException;
import java.beans.XMLEncoder;
import java.io.IOException;
import java.io.OutputStream;
import java.util.*;

/**
 * Created by somallg on 5/21/14.
 */
public class RabbitCounterServlet extends HttpServlet {
    /**
     *
     */
    private static final long serialVersionUID = 6813424505866078479L;

    private Map<Integer, Integer> cache;

    // Executed when servlet is first loaded into container
    public void init() {
        cache = Collections.synchronizedMap(new HashMap<Integer, Integer>());
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        String num = request.getParameter("num");

        // If no query string, return full list
        if (num == null) {
            Collection<Integer> fibs = cache.values();
            send_typed_response(request, response, fibs);
        } else {
            try {
                Integer key = Integer.parseInt(num.trim());
                Integer fib = cache.get(key);
                if (fib == null) fib = -1;
                send_typed_response(request, response, fib);
            } catch (NumberFormatException e) {
                send_typed_response(request, response, -1);
            }
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        String nums = request.getParameter("nums");
        if (nums == null) {
            throw new HTTPException(HttpServletResponse.SC_BAD_REQUEST);
        }

        // Extract the integers from a string such as: [1, 2, 3]
        nums = nums.replace('[', '\0');
        nums = nums.replace(']', '\0');
        String[] parts = nums.split(", ");
        List<Integer> list = new ArrayList<Integer>();
        for (String next : parts) {
            int n = Integer.parseInt(next.trim());
            cache.put(n, countRabbits(n));
            list.add(cache.get(n));
        }

        send_typed_response(request, response, list + " added.");
    }

    private Integer countRabbits(int n) {
        if (n < 0) throw new HTTPException(403);

        if (n < 2) return n;

        if (cache.containsKey(n)) return cache.get(n);
        if (cache.containsKey(n - 1) && cache.containsKey(n - 2)) {
            cache.put(n, cache.get(n - 1) + cache.get(n - 2));
            return cache.get(n);
        }

        int fib = 1, prev = 0;
        for (int i = 2; i <= n; i++) {
            int temp = fib;
            fib += prev;
            prev = temp;
        }

        cache.put(n, fib);
        return fib;
    }

    public void doDelete(HttpServletRequest request, HttpServletResponse response) {
        String key = request.getParameter("num");
        // Only one Fibonacci number may be deleted at a time
        if (key == null)
            throw new HTTPException(HttpServletResponse.SC_BAD_REQUEST);

        try {
            int n = Integer.parseInt(key.trim());
            cache.remove(n);
            send_typed_response(request, response, n + " deleted.");
        } catch (NumberFormatException e) {
            throw new HTTPException(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    public void doPut(HttpServletRequest req, HttpServletResponse res) {
        throw new HTTPException(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
    }

    public void doInfo(HttpServletRequest req, HttpServletResponse res) {
        throw new HTTPException(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
    }

    public void doOptions(HttpServletRequest req, HttpServletResponse res) {
        throw new HTTPException(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
    }

    private void send_typed_response(HttpServletRequest request, HttpServletResponse response, Object data) {
        String desired_typed = request.getHeader("accept");

        if (desired_typed.contains("text/plain"))
            send_plain(response, data);
        else if (desired_typed.contains("text/html"))
            send_html(response, data);
        else
            send_xml(response, data);
    }

    private void send_html(HttpServletResponse response, Object data) {
        String html_start =
                "<html><head><title>send_html response</title></head><body><div>";
        String html_end = "</div></body></html>";
        String html_doc = html_start + data.toString() + html_end;
        send_plain(response, html_doc);
    }

    private void send_plain(HttpServletResponse response, Object data) {
        try {
            OutputStream out = response.getOutputStream();
            out.write(data.toString().getBytes());
            out.flush();
        } catch (IOException e) {
            throw new HTTPException(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

    private void send_xml(HttpServletResponse response, Object data) {
        try {
            XMLEncoder enc = new XMLEncoder(response.getOutputStream());
            enc.writeObject(data.toString());
            enc.close();
        } catch (IOException e) {
            throw new HTTPException(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }
}
