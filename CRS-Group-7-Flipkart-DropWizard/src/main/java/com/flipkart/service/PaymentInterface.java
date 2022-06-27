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

    /**
     * Make payment for certain reference ID with a payment type (UPI/Cheque/Net banking)
     * @param referenceId reference ID of transaction
     * @param paymentType payment type
     * @return success or failure
     */
    Boolean makePayment(String referenceId, String paymentType);
}
