package com.java.user.web.servlet;

import cn.itcast.commons.CommonUtils;
import com.java.user.domain.User;
import com.java.user.service.UserException;
import com.java.user.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Joe on 2016/5/15.
 */
@WebServlet(name = "RegistServlet" ,urlPatterns="/com/java/user/web/servlet/RegistServlet")
public class RegistServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        UserService userService=new UserService();

        /*
        * 1、封装表单(封装到User对象中)
        *
        * */

        User form= CommonUtils.toBean(request.getParameterMap(),User.class);

        /*
        * 2、调用regist()方法，传递form
        * */
        try {
            userService.regist(form);
            response.getWriter().print("<h1>注册成功<h1/>" +
                    "<a href="+request.getContextPath()+"/user/login.jsp"
                    +"点击这里登陆<a/>");
        } catch (UserException e) {
            //保存异常信息，到request域中

            request.setAttribute("msg",e.getMessage());
            //回显功能
            request.setAttribute("user",form);
            request.getRequestDispatcher("/user/regist.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}