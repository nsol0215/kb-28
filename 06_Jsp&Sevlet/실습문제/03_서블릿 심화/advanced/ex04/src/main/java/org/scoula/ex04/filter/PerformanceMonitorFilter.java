package org.scoula.ex04.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/*")
public class PerformanceMonitorFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        long start = System.currentTimeMillis();

        chain.doFilter(request, response);

        long end = System.currentTimeMillis();

        HttpServletRequest req = (HttpServletRequest) request;
        String url = req.getRequestURI();

        System.out.println("[" + start + "] " + url + " - " + (end - start) + "ms 소요.");
    }
    // init, destroy 생략 가능
}
