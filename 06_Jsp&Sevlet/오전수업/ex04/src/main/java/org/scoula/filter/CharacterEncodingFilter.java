package org.scoula.filter;

import javax.servlet.*;
import java.io.IOException;


//@WebFilter(urlPatterns = {"/*"})
public class CharacterEncodingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("필터 초기화 담당");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");

        filterChain.doFilter(request, response);

    }

    @Override
    public void destroy() {
        System.out.println("필터 소멸됨.");
    }
}
