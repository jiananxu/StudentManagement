package com.java.user.test.dao;

/**
 * Created by Joe on 2016/5/16.
 */
public class LTest {
    private String path;
public LTest(){
    path=this.getClass().getResource("/users.xml").getPath();
    System.out.println(path);
}
    public static void main(String[] args) {
        LTest LTest =new LTest();
    }
}
