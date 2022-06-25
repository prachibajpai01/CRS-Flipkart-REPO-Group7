package com.flipkart.dao;

import com.flipkart.bean.Payment;

import java.util.ArrayList;

/**
 * Interface for payment dao
 */

public interface PaymentDaoInterface {
    public ArrayList<Payment> getPaymentInfo(String studentId);

    public Boolean makePayment(String referenceId, String paymentType);
}
