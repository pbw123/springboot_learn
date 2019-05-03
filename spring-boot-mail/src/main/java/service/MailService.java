package service;

/**
 * Created by 公子白 on 2019/4/24.
 */
public interface MailService {
    /**
     * 发送简单邮件
     */
    void sendMail(String to,String subject,String content);
}
