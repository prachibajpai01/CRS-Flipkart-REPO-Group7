package com.flipkart.bean;

public class Payment {

    /**
     * reference Id getter
     * @return reference Id
     */
    public String getReferenceId() {
        return referenceId;
    }

    /**
     * Reference Id setter
     * @param referenceId
     */

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    /**
     * Student Id getter
     * @return Student Id
     */

    public String getStudentId() {
        return studentId;
    }

    /**
     * Student Id setter
     * @param studentId
     */

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    /**
     * Amount getter
     * @return amount
     */

    public int getAmount() {
        return amount;
    }

    /**
     * amount setter
     * @param amount
     */

    public void setAmount(int amount) {
        this.amount = amount;
    }

    /**
     * paid getter
     * @return paid
     */

    public Boolean getPaid() {
        return paid;
    }

    /**
     * paid setter
     * @param paid
     */

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }

    /**
     * Type getter
     * @return Type
     */

    public String getType() {
        return type;
    }

    /**
     * Type setter
     * @param type
     */

    public void setType(String type) {
        this.type = type;
    }

    public String referenceId;
    public String studentId;
    public int amount;
    public Boolean paid;
    public String type;

    public Payment() {
    }

    public Payment(String referenceId, String studentId, int amount, Boolean paid, String type) {
        this.referenceId = referenceId;
        this.studentId = studentId;
        this.amount = amount;
        this.paid = paid;
        this.type = type;
    }


}
