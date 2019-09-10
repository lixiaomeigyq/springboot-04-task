package com.atguigu.task.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2019/9/10.
 */
@Service
public class ScheduleService {

/*    second(秒) , minute（分）, hour（时）, day of month（日）, month（月）,day of week（周几）
    0 * * * * MON-FRI
    @Scheduled(cron="0 * * * * *")
    @Scheduled(cron = "0,1,2,3,4,5 * * * * *")
    @Scheduled(cron = "0-4 * * * * *")

    【0 0/5 14,18 * * ?】每天14点整， 和18点整，每隔5分钟执行一次
    【0 15 10 ? * 1-6】每个月的周-至周六10:15分执行次
    【0 0 2 ? * 6L】每个月的最后一个周六凌晨2点执行次
    【0 0 2 LW * ?】每个月的最后一个工作日读晨2点执行一次
    【0 0 2-4 ? * 1#1】每个月的第一个周一晨2点到4点期间，每个整点都执行一次; |


    */


    @Scheduled(cron = "0/4 * * * * *")//每四秒执行一次
    public void hello(){
        System.out.println("hello...");
    }

}
