package com.ratel.mockservices;

/**
 * @author zhangxn
 * @date 2022/1/6  23:15
 */
public class AppServices2 {
    private EmailService emailService;
    private SMSService smsService;

    public boolean sendSMS(String msg) {
        return smsService.send(msg);
    }

    public boolean sendEmail(String msg) {
        return emailService.send(msg);
    }
}
