package org.scoula.ex04.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/cart_delete")
public class CartDeleteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();

        // 1. 세션 객체 추출
        HttpSession session = req.getSession(false); // 세션이 없으면 새로 생성하지 않음

        // 2. 세션 삭제 (내용 전부 삭제)
        if (session != null) {
            session.invalidate();
        }

        // 3. 결과 화면 출력
        out.println("<html><body>");
        out.println("<h2>장바구니 비웠음!!</h2>");
        out.println("<a href='session_product.jsp'>상품 선택 페이지</a>");
        out.println("</body></html>");
    }
}
