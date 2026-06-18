package org.scoula.ex04.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;


@WebServlet("/cart_delete")
public class CartDeleteServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession();
        session.invalidate();

        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("장바구니 비웠음!!<a href='session_product.jsp'>상품 선택 페이지</a>");
    }
}