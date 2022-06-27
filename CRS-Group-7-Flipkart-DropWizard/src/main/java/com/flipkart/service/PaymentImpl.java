package com.flipkart.service;

import com.flipkart.bean.Payment;
import com.flipkart.dao.PaymentDaoInterface;
import com.flipkart.dao.PaymentDaoOperation;

import java.util.ArrayList;

public class PaymentImpl implements PaymentInterface {
    PaymentDaoInterface paymentDaoInterface = new PaymentDaoOperation();

    /**
     * Payment info getter
     *
     * @param studentId
     * @return
     */

    @Override
    public ArrayList<Payment> getPaymentInfo(String studentId) {
        return paymentDaoInterface.getPaymentInfo(studentId);
    }

    @Override
    public Boolean makePayment(String referenceId, String paymentType) {
        return paymentDaoInterface.makePayment(referenceId, paymentType);
    }
}
