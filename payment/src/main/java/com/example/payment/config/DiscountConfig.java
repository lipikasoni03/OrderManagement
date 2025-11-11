//package com.example.payment.config;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.cloud.context.config.annotation.RefreshScope;
//import org.springframework.stereotype.Component;
//
//@Component
//@RefreshScope  // Allows live refresh without restarting service
//public class DiscountConfig {
//
//    @Value("${discount.amount}")
//    private double discountAmount;
//
//    public double getDiscountAmount() {
//        return discountAmount;
//    }
//}