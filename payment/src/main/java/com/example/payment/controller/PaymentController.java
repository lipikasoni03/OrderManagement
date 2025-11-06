package com.example.payment.controller;

import com.example.payment.Entity.Paymentvalue;
import com.example.payment.model.PaymentDto;
import com.example.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")

public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping
    public PaymentDto doPayment(@RequestBody PaymentDto paymentDto) {
        return paymentService.makePayment(paymentDto);
    }

    @GetMapping("/{id}")
    public PaymentDto getPaymentDetails(@PathVariable Long id) {
        return paymentService.getPayment(id);
    }
}
