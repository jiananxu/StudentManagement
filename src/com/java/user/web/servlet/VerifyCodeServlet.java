package com.java.user.web.servlet;

import cn.itcast.vcode.utils.VerifyCode;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by Joe on 2016/5/17.
 */
@WebServlet(name = "VerifyCodeServlet" ,urlPatterns ="/com/java/user/web/servlet/VerifyCodeServlet" )
public class VerifyCodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        VerifyCode vc=new VerifyCode();

        BufferedImage image=vc.getImage();

        request.getSession().setAttribute("session_vcode",vc.getText());
        System.out.println(vc.getText());
        VerifyCode.output(image,response.getOutputStream());
    }
}
