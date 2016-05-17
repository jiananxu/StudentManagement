package com.java.user.test.dao;

import com.java.user.dao.UserDAO;
import com.java.user.domain.User;
import org.junit.Test;

/**
 * Created by Joe on 2016/5/16.
 */
public class UserDaoTest {
@Test
public void testFindByUsername(){

    UserDAO userDAO=new UserDAO();
    User user=userDAO.findByUsename("张三");
    System.out.println(user);

}
@Test
public void  testAdd(){
    UserDAO userDAO=new UserDAO();

    User user=new User();
    user.setUsername("徐家男");
    user.setPassword("1024");
    userDAO.add(user);
}

}
