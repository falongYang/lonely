package com.briup.estore.web.servlet;

import com.briup.estore.bean.Customer;
import com.briup.estore.service.ICustomerService;
import com.briup.estore.service.impl.CustomerServiceImpl;
import jdk.nashorn.internal.ir.CatchNode;

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
public class RegisterServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        try {

            // 获取页面数据
            String name = req.getParameter("name");
            String password = req.getParameter("password");
            String zipCode = req.getParameter("zipCode");
            String telephone = req.getParameter("telephone");
            String email = req.getParameter("email");

            // 调用service
            ICustomerService customerService = new CustomerServiceImpl();

            // 将接收到的数据封装成对象
            Customer customer = new Customer();
            customer.setName(name);
            customer.setPassword(password);
            customer.setZip(Integer.parseInt(zipCode));
            customer.setTelephone(telephone);
            customer.setEmail(email);

            // 保存数据
            customerService.saveOrUpdate(customer);

        }catch (Exception e) {
            // 发生异常时需要对异常进行处理。并且把异常信息发送给页面让用户看到
            // 重定向到登录页面
            session.setAttribute("msg", "注册失败，请重新出注册: " + e.getMessage());
            resp.sendRedirect(req.getContextPath() + "/register.jsp");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}