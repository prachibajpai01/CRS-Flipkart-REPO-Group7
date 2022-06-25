package com.flipkart.dao;

import com.flipkart.bean.Payment;

import java.util.ArrayList;

/**
 * Interface for payment dao
 */

public interface PaymentDaoInterface {

    /**
     * Get the payment information for a student
     * @param studentId ID of student
     * @return list of payment information
     */
    public ArrayList<Payment> getPaymentInfo(String studentId);

    /**
     * Make payment with reference ID and payment type
     * @param referenceId reference ID of transaction
     * @param paymentType type of payment (UPI/Cheque/Net banking)
     * @return success or failure
     */
    public Boolean makePayment(String referenceId, String paymentType);
}
