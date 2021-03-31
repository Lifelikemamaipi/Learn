package 算法;

/**
 * @author ：Good_M
 * @date ：Created in 2021 2021/3/31 21:35
 */
public class 剔除链表中重复元素 {

    public static void main(String[] args) {
        ListNode head = new ListNode(3,new ListNode(3,new ListNode(3,new ListNode(3,new ListNode(3,new ListNode(3,new ListNode(3,null)))))));
        deleteDuplicates(head);
    }


    /**
     * 整体思路，保存当前节点的前置节点，然后用当前节点与后面节点比较，如果val相等则一直找，直到找到不同的
     * 通过将前置节点的next指向不同节点，达到删除节点的效果
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //虚拟节点
        ListNode result = new ListNode(-999);
        ListNode preNode = result;
        //标识本次比较是否有重复节点
        boolean findFlag = false;
        while (head.next != null) {
            //当前节点和下一个节点值不同
            if (head.val != head.next.val) {
                //如果当前节点已经是重复的节点，则将后面的节点给到前置节点，否则将本节点给到前置节点
                preNode.next = findFlag ? head.next : head;
                //如果当前节点没有重复，则将前置节点移到当前节点
                if (!findFlag) {
                    preNode = head;
                }
                findFlag = false;
            } else {
                findFlag = true;
            }
            head = head.next;
        }
        //如果整体结束的时候标识为true，说明最后的全部都是重复的，这时候将前置节点的next置为null
        if (findFlag) {
            preNode.next = null;
        }
        return result.next;
    }


    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


}
