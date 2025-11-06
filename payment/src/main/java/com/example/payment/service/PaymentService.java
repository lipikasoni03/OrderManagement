
package com.example.payment.service;

import com.example.payment.Entity.Paymentvalue;
import com.example.payment.model.PaymentDto;
import com.example.payment.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;
    private boolean isPaid;
    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean isPaid) {
        this.isPaid = isPaid;
    }    public PaymentDto makePayment(PaymentDto dto) {

        Paymentvalue payment = new Paymentvalue();
        payment.setOrderId(dto.getOrderId());
        payment.setPaymentMode(dto.getPaymentMode());
        payment.setAmount(dto.getAmount());

        if (dto.getAmount() == null || dto.getAmount() <= 0) {
            payment.setStatus("FAILED");
            payment.setMessage("Payment failed: no amount paid");
        }
        else if (dto.getPaymentMode().equalsIgnoreCase("CASH") ||
                dto.getPaymentMode().equalsIgnoreCase("GPAY") ||
                dto.getPaymentMode().equalsIgnoreCase("UPI") ||
                dto.getPaymentMode().equalsIgnoreCase("CARD") ||
                dto.getPaymentMode().equalsIgnoreCase("PAYTM")) {

            payment.setStatus("SUCCESS");
            payment.setMessage("Payment processed successfully");
        }
        else {
            payment.setStatus("FAILED");
            payment.setMessage("Payment failed: invalid payment mode");
        }

        Paymentvalue savedPayment = paymentRepository.save(payment);

        PaymentDto response = new PaymentDto();
        response.setPaymentId(savedPayment.getId());
        response.setOrderId(savedPayment.getOrderId());
        response.setPaymentMode(savedPayment.getPaymentMode());
        response.setAmount(savedPayment.getAmount());
        response.setStatus(savedPayment.getStatus());
        response.setMessage(savedPayment.getMessage());

        return response;
    }

    public PaymentDto getPayment(Long id) {
        Optional<Paymentvalue> optionalPayment = paymentRepository.findById(id);

        if (optionalPayment.isEmpty()) return null;

        Paymentvalue payment = optionalPayment.get();
        PaymentDto response = new PaymentDto();
        response.setPaymentId(payment.getId());
        response.setOrderId(payment.getOrderId());
        response.setPaymentMode(payment.getPaymentMode());
        response.setAmount(payment.getAmount());
        response.setStatus(payment.getStatus());
        response.setMessage("Payment retrieved successfully");

        return response;
    }


}
