//package com.ougen.quartz_write;
//
//
//import org.quartz.*;
//import org.quartz.impl.StdSchedulerFactory;
//
//
//import static org.quartz.JobBuilder.newJob;
//import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
//
//
//
///**
// * @author:ougen
// * @date:2018/9/49:26
// */
//public class QuartzDemo {
//    //job类必须是public的
//    public static void main(String[] args) {
//        try {
//            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
//
//            JobDetail jobDetail = newJob(MyJob.class)
//                    .withIdentity("job1", "group1")
//                    .build();
//            Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1","group1")
//                    .startNow().withSchedule(simpleSchedule()
//                            .withIntervalInSeconds(1)
//                            .repeatForever())
//                    .build();
//            scheduler.scheduleJob(jobDetail,trigger);
//            scheduler.start();
//
//        } catch (SchedulerException e) {
//            e.printStackTrace();
//        }
//    }
//}
//
