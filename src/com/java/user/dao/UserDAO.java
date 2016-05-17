package com.java.user.dao;

import com.java.user.domain.User;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.*;

//数据类
public class UserDAO {

    private String path="C:/users.xml" ;


    /*
    * 1、get document
    * 2、xpath查询
    *   3、查询是否为空 ，为null，return null
    *   4、查询不是null， 将element封装到User对象中
    * */
    public User findByUsename(String username) {
        //创建解析器
        try {
        SAXReader saxReader = new SAXReader();
            Document doc = saxReader.read(path);
            Element element = (Element) doc.selectSingleNode("//user[@username='" + username + "']");
            if (element == null) {return null;}

            User user = new User();
            String attiusername = element.attributeValue("username");  //获取该元素名为username的属性值
            String arripassword = element.attributeValue("password");

            user.setUsername(attiusername);
            user.setPassword(arripassword);
            return  user;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public void add(User user) {


        try {
            SAXReader saxReader = new SAXReader();
            Document doc = saxReader.read(path);
            //获取跟元素
            Element root = doc.getRootElement();
            Element userEle = root.addElement("user");
            //为userEle设置属性
            userEle.addAttribute("username", user.getUsername());
            userEle.addAttribute("password", user.getPassword());

            //保存文档

            OutputFormat format=new OutputFormat("\t",true);
            format.setTrimText(true); //清除原有换行和缩进
            XMLWriter xmlWriter;


            xmlWriter=new XMLWriter(
                    new OutputStreamWriter(
                            new FileOutputStream(path),"utf-8"),format);
            xmlWriter.write(doc);
            xmlWriter.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
