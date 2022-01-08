package com.ratel.mockservices;

/**
 * @author zhangxn
 * @date 2022/1/6  23:15
 */
public class EmailService implements Service {

    @Override
    public boolean send(String msg) {
        System.out.println("Sending email");
        return true;
    }

}