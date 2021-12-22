package com.wdg.pattern.structure.chain;

/**
 *  @Description 采购单：请求类
 *  
 *  @author wudiguang
 *  @Date 2021/12/2
 */
public class PurchaseRequest {
    private Integer amount;
    private Integer number;
    private String purpose;

    public PurchaseRequest(Integer amount, Integer number, String purpose) {
        this.amount = amount;
        this.number = number;
        this.purpose = purpose;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }
}
