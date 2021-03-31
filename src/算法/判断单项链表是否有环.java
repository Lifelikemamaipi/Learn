package 算法;

/**
 * @author ：Good_M
 * @date ：Created in 2021 2021/3/30 21:55
 */
public class 判断单项链表是否有环 {

    public static void main(String[] args) {
        ListNode tail = new ListNode(-4);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(2);
        ListNode head = new ListNode(3);
        head.next = node3;
        node3.next = node2;
        node2.next = tail;
        tail.next = node3;
        System.out.println(hasCycle(head));
    }


    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        if (head.next == head) {
            return true;
        }
        ListNode tail = head.next;

        while (tail != null){
            if (head == tail) {
                return true;
            }else if (tail.next == null) {
                return false;
            }
            //一个步进1，一个步进2
            head = head.next;
            tail = tail.next.next;
        }
        return false;
    }

}
