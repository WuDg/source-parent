package simple.arr;

import java.util.Objects;

/**
 *  @Description
 *
 *  https://leetcode-cn.com/problems/add-two-numbers/
 *  问题描述：两个链表拼接问题，外加保存进位
 *
 *  问题解法：使用两个节点，一个是头节点，一个是移动节点（保存当前两个链表合并的数据），头节点和移动节点初始地址相同
 *
 *  @author wudiguang
 *  @Date 2021/11/19
 */

public class Demo002 {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 4};
        ListNode l1 = new ListNode(2);
        ListNode l11 = new ListNode(4);
        ListNode l12 = new ListNode(3);

        ListNode l2 = new ListNode(5);
        ListNode l21 = new ListNode(6);
        ListNode l22 = new ListNode(4);
        ListNode l23 = new ListNode(9);

        l1.next = l11;
        l11.next = l12;

        l2.next = l21;
        l21.next = l22;
//        l22.next = l23;

        new Demo002().addTwoNumbers1(l1, l2);
    }

    /**
     * 个人解法：未考虑尽量减少变量使用问题，未考虑使用 % 和 / 分别获取取余和取整
     * @param l1 链表1
     * @param l2 链表2
     * @return 组合链表
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int first = l1.val + l2.val;
        boolean push = first >= 10;
        ListNode result, head;
        head = result = new ListNode(push ? (first - 10) : first);
        l1 = l1.next;
        l2 = l2.next;
        while(l1 != null || l2 != null){
            result.next = new ListNode(0);
            result = result.next;
            boolean l1End = Objects.isNull(l1);
            boolean l2End = Objects.isNull(l2);
            int value = (l1End ? 0 : l1.val) +  (l2End ? 0 : l2.val) + (push ? 1 : 0);
            push = value >= 10;
            result.val = value >= 10 ? (value - 10) : value;
            if(!l1End){
                l1 = l1.next;
            }
            if(!l2End) {
                l2 = l2.next;
            }
        }
        if(push){
            result.next = new ListNode(1);
        }
        return head;
    }

    /**
     * 官方解法
     * @param l1 链表1
     * @param l2 链表2
     * @return 组合链表
     */
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode tail = null, head = null;
        while(l1 != null || l2 != null){
            int value = (l1 == null ? 0 : l1.val) +  (l2 == null ? 0 : l2.val) + carry;
            if(Objects.isNull(head)){
                tail = head = new ListNode(value % 10);
            }else {
                tail.next = new ListNode(value % 10);
                tail = tail.next;
            }
            carry = value / 10;
            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null) {
                l2 = l2.next;
            }
        }
        if(carry > 0){
            tail.next = new ListNode(1);
        }
        return head;
    }

    public static class ListNode {
         int val;
         ListNode next;

        public ListNode(int val) { this.val = val; }
    }
}
