package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * Created by 公子白 on 2019/4/24.
 */
@Service
//@Async
public class TaskService {
    @Autowired
    private MailService mailService;
    @Scheduled(cron = "0 00 10 * * ?")
    public void proces(){
        mailService.sendMail("16422802@qq.com","伊天敬",
                "八周的时间过的很快");
        System.out.println("发送成功");
    }

}