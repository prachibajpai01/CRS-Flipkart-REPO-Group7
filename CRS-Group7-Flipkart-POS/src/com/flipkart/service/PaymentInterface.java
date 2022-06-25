package com.flipkart.service;

import com.flipkart.bean.Payment;

import java.util.ArrayList;

public interface PaymentInterface {
    /**
     * getting payment info
     * @param studentId
     * @return
     */
    ArrayList<Payment> getPaymentInfo(String studentId);

    Boolean makePayment(String referenceId, String paymentType);
}
