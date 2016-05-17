package com.java.user.service;

/**
 * Created by Joe on 2016/5/16.
 */
//自定义异常
    //只是给出父类的构造器即可，方便用来创建对象
public class UserException extends  Exception {

    public UserException() {
    }

    public UserException(String message) {
        super(message);
    }

    public UserException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserException(Throwable cause) {
        super(cause);
    }

}
