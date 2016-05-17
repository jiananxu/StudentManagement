package com.java.user.service;

import com.java.user.dao.UserDAO;
import com.java.user.domain.User;

/**
 * Created by Joe on 2016/5/15.
 */
/**
*1、校验用户名是否被注册
*2、添加用户
*/
public class UserService {

    private UserDAO userDAO=new UserDAO();

    //注册功能
    public  void regist(User user) throws UserException{
      User _user=  userDAO.findByUsename(user.getUsername());
        if (_user!=null) {
            throw new UserException("用户名已经被注册，请重新输入");
        }
        userDAO.add(user);
    }
}
