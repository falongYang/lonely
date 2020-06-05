package com.briup.estore.web.lisenter;

import com.briup.estore.service.ICategoryService;
import com.briup.estore.service.impl.CategoryServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestListener;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: yfl
 * \* Date: 2020/6/3
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class IndexLisenter implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // tomcat启动时会调用这个方法
        ServletContext application = sce.getServletContext();
        ICategoryService categoryService = new CategoryServiceImpl();
        // 把查询出的数据放到application中
        application.setAttribute("categories",categoryService.findAllCategoryEX());

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}