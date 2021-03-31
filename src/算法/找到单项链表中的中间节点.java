package 算法;

/**
 * @author ：Good_M
 * @date ：Created in 2021 2021/3/30 21:50
 */
public class 找到单项链表中的中间节点 {

    public static void main(String[] args) {
        ListNode head = new ListNode(0,new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5,null))))));
        System.out.println(findMiddle(head).val);
    }


    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode findMiddle(ListNode head){
        if (head == null || head.next == null) {
            return head;
        }
        ListNode tail = head.next.next;
        while (tail != null) {
            head = head.next;
            if (tail.next != null) {
                tail = tail.next.next;
            } else {
                return head;
            }
        }
        return head.next;
    }



}
