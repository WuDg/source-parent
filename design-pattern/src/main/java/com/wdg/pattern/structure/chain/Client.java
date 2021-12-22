package com.wdg.pattern.structure.chain;

/**
 *  @Description 责任链模式-审批流程
 *
 *  @author wudiguang
 *  @Date 2021/12/2
 */
public class Client {
    public static void main(String[] args) {
        // 审批人
        Approver wjzhang,gyang,jguo,meeting;
        // 主任
        wjzhang = new Director("张无忌");
        // 副董事长
        gyang = new VicePresident("杨过");
        // 董事长
        jguo = new President("郭靖");
        // 董事会
        meeting = new Congress("董事会");
        //创建职责链，主任 -> 副董事长 -> 董事长 -> 董事会
        wjzhang.setSuccessor(gyang);
        gyang.setSuccessor(jguo);
        jguo.setSuccessor(meeting);
        //创建采购单
//        PurchaseRequest pr1 = new PurchaseRequest(45000,10001,"购买倚天剑");
//        wjzhang.processRequest(pr1);
//        PurchaseRequest pr2 = new PurchaseRequest(60000,10002,"购买《葵花宝典》");
//        wjzhang.processRequest(pr2);
//        PurchaseRequest pr3 = new PurchaseRequest(160000,10003,"购买《金刚经》");
//        wjzhang.processRequest(pr3);
        PurchaseRequest pr4 = new PurchaseRequest(800000,10004,"购买桃花岛");
        wjzhang.processRequest(pr4);
    }
}