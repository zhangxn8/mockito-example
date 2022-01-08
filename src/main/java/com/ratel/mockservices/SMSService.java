package com.ratel.mockservices;

/**
 * @author zhangxn
 * @date 2022/1/6  23:16
 */
public class SMSService  implements Service {

    @Override
    public boolean send(String msg) {
        System.out.println("Sending SMS");
        return true;
    }
}
