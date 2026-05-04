//package com.mecaps.blogApp.concept;
//
//import org.springframework.scheduling.annotation.Async;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//@Component
//public class MyScheduler {
//
//    @Scheduled(fixedRate = 6000) // Runs every 6 seconds (6000 ms)
//    @Scheduled(fixedDelay = 6000) // Runs 6 seconds after previous execution finishes
//    @Scheduled(cron = "0 * * * * ?" ) // Runs every minute
//    public void runEveryMinute(){
//        System.out.println("Run Every Minute....");
//    }
//
//    @Async
//    public void sendEmailANdCreateUser(){
//
//        System.out.println("Async ....");
//    }
//}
//
