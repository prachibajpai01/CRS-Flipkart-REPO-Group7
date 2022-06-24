package com.flipkart.service;

import com.flipkart.bean.Payment;

import java.util.ArrayList;

public interface PaymentInterface {
    /**
     * getting payment info
     * @param studentId
     * @return
     */
    public ArrayList<Payment> getPaymentInfo(String studentId);
}
