package com.briup.estore.web.servlet;

import com.briup.estore.bean.Customer;
import com.briup.estore.service.ICustomerService;
import com.briup.estore.service.impl.CustomerServiceImpl;

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
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取用户名和密码
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        // 调用service进行判断
        ICustomerService customerService = new CustomerServiceImpl();
        Customer customer = customerService.findCustomerByUserNameAndPassword(name, password);
        HttpSession session = req.getSession();
        if (customer == null){
            session.setAttribute("msg","登陆失败，用户名密码错误");
            resp.sendRedirect(req.getContextPath()+"/login.jsp");
        }else {
            resp.sendRedirect(req.getContextPath()+"/index.jsp");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}