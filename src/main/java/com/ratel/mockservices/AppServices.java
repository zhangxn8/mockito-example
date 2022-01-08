package com.ratel.mockservices;

/**
 * @author zhangxn
 * @date 2022/1/6  23:14
 */
public class AppServices {

    private EmailService emailService;
    private SMSService smsService;

    public AppServices(EmailService emailService, SMSService smsService) {
        this.emailService = emailService;
        this.smsService = smsService;
    }

    public boolean sendSMS(String msg) {
        return smsService.send(msg);
    }

    public boolean sendEmail(String msg) {
        return emailService.send(msg);
    }
}
