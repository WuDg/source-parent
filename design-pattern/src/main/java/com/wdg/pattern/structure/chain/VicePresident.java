package com.wdg.pattern.structure.chain;
/**
 *  @Description 副董事长类：具体处理者
 *
 *  @author wudiguang
 *  @Date 2021/12/2
 */
class VicePresident extends Approver {
    public VicePresident(String name) {
        super(name);
    }
    //具体请求处理方法
    public void processRequest(PurchaseRequest request) {
        if (request.getAmount() < 100000) {
            System.out.println("副董事长" + this.name + "审批采购单：" + request.getNumber() + "，金额：" + request.getAmount() + "元，采购目的：" + request.getPurpose() + "。");  //处理请求
        }
        else {
            System.out.println("当前是董事长，进入下一审批流程");
            this.successor.processRequest(request);  //转发请求
        }
    }
}