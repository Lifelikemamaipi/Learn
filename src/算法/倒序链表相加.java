package 算法;

import java.util.List;

/**
 * https://leetcode-cn.com/problems/add-two-numbers/
 * @author ：Good_M
 * @date ：Created in 2021 2021/3/30 21:57
 */
public class 倒序链表相加 {


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //创建虚拟节点
        ListNode result = new ListNode();
        //操作节点，为了保留result节点，方便输出结果
        ListNode curNode = result;
        boolean isCarry = false;
        while (l1 != null || l2 != null || isCarry) {
            ListNode temp = new ListNode();
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            temp.val = isCarry ? val1 + val2 + 1 : val1 + val2;
            //判断是否需要进位
            isCarry = temp.val / 10 > 0;
            //只取各位
            temp.val = temp.val % 10;
            //两个节点同时后移
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
            //插入新节点
            curNode.next = temp;
            //将当前节点后移，方便下一次插入新的节点
            curNode = temp;
        }
        return result.next;
    }


    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}
