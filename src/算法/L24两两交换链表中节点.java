package 算法;

import java.util.List;

/**
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/submissions/
 * @author ：Good_M
 * @date ：Created in 2021 2021/4/1 22:37
 */
public class L24两两交换链表中节点 {


    public ListNode swapPairs(ListNode head) {
        //构建结果对象，方便返回
        ListNode result = new ListNode();
        result.next = head;
        //保存前置节点
        ListNode preNode = result;
        while (head != null && head.next != null) {
            //先将下下个节点暂存，否则后面断开连接后找不到节点了
            ListNode temp = head.next.next;
            //将下下个节点设为head，断开head.next以后就完成了反转操作
            head.next.next = head;
            //将前置节点的下一个节点先指向反转后的节点，因为反转以后head.next就在head前面了
            preNode.next = head.next;
            //断开head.next并指定到之前暂存的节点上
            head.next = temp;
            //完成上面操作以后，其实对于下一个节点来说，head就是下一个节点的前置节点了
            preNode = head;
            //head前移
            head = head.next;
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
