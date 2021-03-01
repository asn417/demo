package com.asn.web.servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class MyServlet implements Servlet {
    public MyServlet(){
        System.out.println("1.构造器");
    }
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("2.初始化");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("3.service");
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        String method = request.getMethod();
        if ("GET".equals(method)){
            doGet();
        }else if ("POST".equals(method)){
            doPost();
        }
    }

    private void doGet(){

    }
    private void doPost(){

    }
    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("4.销毁");
    }
}
