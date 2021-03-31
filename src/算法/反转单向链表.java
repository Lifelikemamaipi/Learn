package 算法;

/**
 * https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/comments/
 * @author ：Good_M
 * @date ：Created in 2021 2021/3/29 21:22
 */
public class 反转单向链表 {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //为了找到最后一个节点
        ListNode newHead = reverseList(head.next);
        //将当前节点放在下一个节点的后面，先形成环，然后再切开和下一个节点的链接，达到反转
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public ListNode reverseList2(ListNode head) {
        //虚拟节点
        ListNode result = null;
        while (head != null) {
            //将next节点提出暂存
            ListNode temp = head.next;
            //将当前节点的下一个节点指向前一个节点
            head.next = result;
            //因为下次循环仍会将head的next指向result，所以此时result保存的应该是当前的节点
            result = head;
            //暂存的节点变为head，为下一次循环准备
            head = temp;
        }
        return result;
    }

}



