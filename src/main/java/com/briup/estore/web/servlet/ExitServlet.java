package com.briup.estore.web.servlet;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: yfl
 * \* Date: 2020/6/3
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class ExitServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 销毁session
        req.getSession().invalidate();
        resp.sendRedirect(req.getContextPath()+"/index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}